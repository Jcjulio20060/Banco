import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;

public class archive {
    private final String nomeArquivo = "Contas.xlsx";

    private String nome;
    private double saldo;

    public archive() {
        // Cria o arquivo e escreve o cabeçalho se ele não existir
        try {
            File file = new File(nomeArquivo);
            if (!file.exists()) {
                Workbook workbook = new XSSFWorkbook();
                Sheet sheet = workbook.createSheet("Contas");

                Row header = sheet.createRow(0);
                header.createCell(0).setCellValue("Titular");
                header.createCell(1).setCellValue("Senha");
                header.createCell(2).setCellValue("Saldo");

                try (FileOutputStream outputStream = new FileOutputStream(nomeArquivo)) {
                    workbook.write(outputStream);
                }
                workbook.close();
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao inicializar o arquivo.", e);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Verifica a conta com base no usuário e senha
    public int verificaConta(String user, int senha) {
        try (FileInputStream fis = new FileInputStream(nomeArquivo);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet("Contas");
            Iterator<Row> iterator = sheet.iterator();
            iterator.next(); // Ignorar o cabeçalho

            while (iterator.hasNext()) {
                Row row = iterator.next();
                String titular = row.getCell(0).getStringCellValue();
                int senhaArquivo = (int) row.getCell(1).getNumericCellValue();
                double saldoArquivo = row.getCell(2).getNumericCellValue();

                if (titular.equals(user) && senhaArquivo == senha) {
                    setNome(titular);
                    setSaldo(saldoArquivo);
                    return 1; // Conta encontrada
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0; // Conta não encontrada
    }

    // Cria uma nova conta
    public int criacaoConta(String user, int senha) {
        try (FileInputStream fis = new FileInputStream(nomeArquivo);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet("Contas");
            Iterator<Row> iterator = sheet.iterator();
            while (iterator.hasNext()) {
                Row row = iterator.next();
                String titular = row.getCell(0).getStringCellValue();

                if (titular.equals(user)) {
                    return 2; // Conta já existe
                }
            }

            // Adiciona a nova conta no arquivo
            int rowNum = sheet.getLastRowNum() + 1;
            Row row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(user);
            row.createCell(1).setCellValue(senha);
            row.createCell(2).setCellValue(0.0);

            try (FileOutputStream fos = new FileOutputStream(nomeArquivo)) {
                workbook.write(fos);
            }
            workbook.close();
            return 1; // Conta criada com sucesso

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0; // Erro na criação
    }

    public void AtualizaDados(double valor) {
        try (FileInputStream fis = new FileInputStream(nomeArquivo);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet("Contas");
            Iterator<Row> iterator = sheet.iterator();
            boolean encontrou = false;

            while (iterator.hasNext()) {
                Row row = iterator.next();
                String titular = row.getCell(0).getStringCellValue();

                if (titular.equals(getNome())) {
                    row.getCell(2).setCellValue(valor);
                    encontrou = true;
                    break;
                }
            }

            if (!encontrou) {
                System.out.println("Erro: Conta não encontrada para atualização.");
                return;
            }

            try (FileOutputStream fos = new FileOutputStream(nomeArquivo)) {
                workbook.write(fos);
            }
            workbook.close();
        } catch (IOException e) {
            System.err.println("Erro ao atualizar os dados da conta: " + e.getMessage());
        }
    }
}
