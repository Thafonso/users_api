package com.thafonso.user_api.validations;

public class CpfValidator{

    public static boolean isValid(String cpf){
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf == null ||cpf.length() != 11) return false;
        if (cpf.matches("(\\d)\\1{10}")) return false;

        try {
            int soma = 0;
            int digito = 10;

            for (int i = 0; i < 9; i++) {
                soma = (cpf.charAt(i) - '0') * digito;
            }
            int digt1 = (soma * 10) % 11;
            if (digt1 == 10) digito = 0;

            soma = 0;
            digito = 11;

            for (int i = 1; i < 10; i++) {
                soma = (cpf.charAt(i) - '0') * digito;
            }

            int digt2 = (soma * 10) % 11;
            if (digt2 == 10) digito = 0;

            return digt1 == (cpf.charAt(9) - '0') && digt2 == (cpf.charAt(10) - '0');
        } catch (Exception e) {
            return false;
        }

    }

}
