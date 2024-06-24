import java.util.Scanner;

public class PrincipalConversor {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        // Setting URL
        String value;
        String base_code="";
        String target_code="";
        try {
            int op;

            do {
                System.out.println("\n***********************************");
                System.out.println("**CONVERSOR DE DIVISAS**");
                System.out.println("1. Dolar ==> Peso Colombiano");
                System.out.println("2. Peso Colombiano ==> Dolar");
                System.out.println("3. Dolar ==> Real Brasilero");
                System.out.println("4. Real Brasilero ==> Dolar");
                System.out.println("5. Dolar ==> Peso Argentino");
                System.out.println("6. Peso Argentino ==> Dolar");
                System.out.println("7. Salir");
                System.out.println("Elija una opción válida...");
                System.out.println("\n********************************");
                op = read.nextInt();

                switch (op) {
                    case 1:
                        base_code = "USD";
                        target_code = "COP";
                        break;
                    case 2:
                        base_code = "COP";
                        target_code = "USD";
                        break;
                    case 3:
                        base_code = "USD";
                        target_code = "BRL";
                        break;
                    case 4:
                        base_code = "BRL";
                        target_code = "USD";
                        break;
                    case 5:
                        base_code = "USD";
                        target_code = "ARS";
                        break;
                    case 6:
                        base_code = "ARS";
                        target_code = "USD";
                        break;
                    case 7:
                        System.out.println("Saliendo de la aplicación...Gracias por usar el conversor...");
                        break;
                    default:
                        System.out.println("Opción seleccionada inválida!!!");
                        break;
                }
                read.nextLine();


                System.out.println("Escriba el valor a convertir:");
                value = read.nextLine();
                ConversorExchanges conversor = new ConversorExchanges();

                Exchanges exchanges = conversor.converterExchanges(base_code, target_code, value);

                System.out.printf("El valor de %s %s corresponde al valor final de ===> %s %s", value, exchanges.base_code(), exchanges.conversion_result(), exchanges.target_code());

            } while (op != 7);
        } catch (Exception e) {
            System.out.println("Valor ingresado erroneo!!!");
        }


    }

}
