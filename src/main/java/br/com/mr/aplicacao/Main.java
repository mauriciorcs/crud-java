package br.com.mr.aplicacao;

import br.com.mr.agenda.Bovino;
import br.com.mr.dao.BovinoDao;

import javax.swing.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Bovino b1 = new Bovino();
        BovinoDao bovinoDao = new BovinoDao();

        // Registro
        b1.setCodigoRegistro("9876");
        b1.setRaca("Brown Swiss");
        b1.setSexo("M");
        b1.setPeso(500);
        b1.setDataNascimento(new Date());
//
//        Bovino b2 = new Bovino();
//        b2.setCodigoRegistro("6789");
//        b2.setRaca("Nelore");
//        b2.setSexo("F");
//        b2.setPeso(305.8);
//        b2.setDataNascimento(new Date());

        bovinoDao.save(b1);

        // Atualizar Boi
//        Bovino c1 = new Bovino();
//        c1.setId(2);
//        c1.setCodigoRegistro("6785");
//        c1.setRaca("Red Angus");
//        c1.setSexo("M");
//        c1.setPeso(500);
//        c1.setDataNascimento(new Date());
//
//        bovinoDao.update(c1);

        // Deletar contato pelo ID
        String codigoRegistro = JOptionPane.showInputDialog("Digite o código de registro do bovino a ser deletado:");
        if (codigoRegistro != null && !codigoRegistro.trim().isEmpty()) {


            int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja deletar o bovino com código de registro " + codigoRegistro + "?", "Confirmação", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                bovinoDao.deleteById(codigoRegistro);
                JOptionPane.showMessageDialog(null, "Bovino deletado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Ação de deletar cancelada.");
                //bovinoDao.deleteById("1234");


                // Vizualização dos registros
                for (Bovino c : bovinoDao.getBovinos()) {
                    System.out.println("Boivino: " + c.getCodigoRegistro());
                }
            }
        }
    }
}
