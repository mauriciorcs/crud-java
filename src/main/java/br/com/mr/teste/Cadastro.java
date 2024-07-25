package br.com.mr.teste;

import br.com.mr.agenda.Bovino;
import br.com.mr.dao.BovinoDao;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Cadastro {
    public static void main(String[] args) {
        BovinoDao bovinoDao = new BovinoDao();
        boolean exit = false;

        while (!exit) {
            String[] options = {"Cadastrar Bovino", "Atualizar Bovino", "Deletar Bovino", "Listar Bovinos", "Sair"};
            int choice = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    cadastrarBovino(bovinoDao);
                    break;
                case 1:
                    atualizarBovino(bovinoDao);
                    break;
                case 2:
                    deletarBovino(bovinoDao);
                    break;
                case 3:
                    listarBovinos(bovinoDao);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    break;
            }
        }
    }

    private static void cadastrarBovino(BovinoDao bovinoDao) {
        String codigoRegistro = JOptionPane.showInputDialog("Digite o código de registro:");
        String raca = JOptionPane.showInputDialog("Digite a raça do bovino:");
        String sexo = JOptionPane.showInputDialog("Digite o sexo do bovino (M/F):");
        double peso = Double.parseDouble(JOptionPane.showInputDialog("Digite o peso do bovino:"));
        Date dataNascimento = new Date();

        Bovino bovino = new Bovino();
        bovino.setCodigoRegistro(codigoRegistro);
        bovino.setRaca(raca);
        bovino.setSexo(sexo);
        bovino.setPeso(peso);
        bovino.setDataNascimento(dataNascimento);
        bovino.setDataNascimento(new Date());

        bovinoDao.save(bovino);
        JOptionPane.showMessageDialog(null, "Bovino cadastrado com sucesso!");
    }

    private static void atualizarBovino(BovinoDao bovinoDao) {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do bovino a ser atualizado:"));
        String codigoRegistro = JOptionPane.showInputDialog("Digite o novo código de registro do bovino a ser atualizado:");
        String raca = JOptionPane.showInputDialog("Digite a nova raça do bovino:");
        String sexo = JOptionPane.showInputDialog("Digite o novo sexo do bovino (M/F):");
        double peso = Double.parseDouble(JOptionPane.showInputDialog("Digite o novo peso do bovino:"));
        Date dataNascimento = new Date();

        Bovino bovino = new Bovino();
        bovino.setId(id);
        bovino.setCodigoRegistro(codigoRegistro);
        bovino.setRaca(raca);
        bovino.setSexo(sexo);
        bovino.setPeso(peso);
        bovino.setDataNascimento(dataNascimento);

        bovinoDao.update(bovino);
        JOptionPane.showMessageDialog(null, "Bovino atualizado com sucesso!");
    }

    private static void deletarBovino(BovinoDao bovinoDao) {
        String codigoRegistro = JOptionPane.showInputDialog("Digite o código de registro do bovino a ser deletado:");
        if (codigoRegistro != null && !codigoRegistro.trim().isEmpty()) {
            int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja deletar o bovino com código de registro " + codigoRegistro + "?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                bovinoDao.deleteById(codigoRegistro);
                JOptionPane.showMessageDialog(null, "Bovino deletado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Ação de deletar cancelada.");
            }
        }
    }

    private static void listarBovinos(BovinoDao bovinoDao) {
        StringBuilder message = new StringBuilder("Lista de Bovinos:\n");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Bovino c : bovinoDao.getBovinos()) {
            message.append("ID: ").append(c.getId()).append(", ");
            message.append("Código Registro: ").append(c.getCodigoRegistro()).append(", ");
            message.append("Raça: ").append(c.getRaca()).append(", ");
            message.append("Sexo: ").append(c.getSexo()).append(", ");
            message.append("Peso: ").append(c.getPeso()).append(", ");
            message.append("Data Nascimento: ").append(sdf.format(c.getDataNascimento())).append("\n");
        }
        JOptionPane.showMessageDialog(null, message.toString());
    }
}
