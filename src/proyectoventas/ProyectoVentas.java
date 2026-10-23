package proyectoventas;
import java.util.Scanner;
/*
 * @author Alexander Marroquín
 */
public class ProyectoVentas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //Asignacion de escaner
        Scanner tc = new Scanner (System.in);
        
        //Creacion de variables
        int op;
        int cantidadProd;
        int codigoProd;
        String nombreProd;
        double precioProd = 0;
        int unidadesProd = 0;
        int pagosEfectivo = 0;
        int pagosTarjeta = 0;
        int pagosTransferencia = 0;
        int pagadoCon = 0;
        int aprobacion = 0;
        String pagoMostrado = " ";
        int ventasCompletadas = 0;
        double subtotalProd;
        double descuento = 0;
        double monto;
        double iva;
        double total;
        int metodoPago;
        double efectivo = 0;
        double cambio = 0;
        double ventaMayor = 0;
        double ventaMenor = 0;
        int productosVendidos = 0;
        double totalVendido = 0;
        
        
        //Inicio del programa
        do{
        //Menu del programa
        System.out.println("====================================================");
        System.out.println("Ingrese una de las siguientes opciones:\n"
                + "1. Registrar una venta. \n"
                + "2. Consultar caja. \n"
                + "3. Mostrar estadisticas. \n"
                + "4. Salir");
        System.out.println("====================================================");
        op = tc.nextInt();
        
        //opcion elegida 
            switch (op){
                case 1:
                    pagadoCon = 0;
                    pagoMostrado = " ";
        System.out.println("====================================================");
                    System.out.println("Registre la venta.");
                    //Solicitar cantidad de productos
        System.out.println("====================================================");            
                    do {
                        System.out.println("Ingrese la cantidad de productos que se venderan.");
                        cantidadProd = tc.nextInt();
                    if(cantidadProd <= 0){
                        System.out.println("Error Cantidad inssuficiente. \n"
                                + "Ingrese nuevamente la cantidad de productos.");
                        }
                    }while (cantidadProd <= 0);
                    
                    //Ingreso de informacion de los productos en ciclo for
        System.out.println("====================================================");
                    double subtotalVenta = 0;
                    int productosVenta = 0;
                    for (int i = 1; i <= cantidadProd; i++){
        System.out.println("====================================================");
                        System.out.println("Ingrese los datos requeridos:");
                        
                        System.out.println("Codigo del producto:");
                        codigoProd = tc.nextInt();
                        
                        //limpieza de buffer 
                        tc.nextLine();
                        
                        System.out.println("Nombre del producto:");
                        nombreProd = tc.nextLine();
                        
                        System.out.println("Precio del producto:");
                        precioProd = tc.nextDouble();
                        while (precioProd <= 0){
                            System.out.println("El precio ingresado no es valido, ingreselo nuevamente:");
                            precioProd = tc.nextDouble();
                        }
                        
                        System.out.println("Unidades del producto:");
                        unidadesProd = tc.nextInt();
                        while (unidadesProd <= 0){
                            System.out.println("La cantidad no es valida, ingresela nuevamente:");
                            unidadesProd = tc.nextInt();
                        }
                        
                        //Calcular los subtotales
                        subtotalProd = precioProd * unidadesProd;
                        subtotalVenta = subtotalVenta + subtotalProd;
                        productosVenta = productosVenta + unidadesProd;
                    }
                    //mostrar los resultados
        System.out.println("====================================================");            
                    System.out.println("El subtotal es de: Q. " + subtotalVenta);
                    
                    //Aplicar descuentos
                    if (subtotalVenta < 200){
                        descuento = 0;
                    }else if (subtotalVenta < 500){
                        descuento = subtotalVenta * 0.05;
                    }else if (subtotalVenta < 1000){
                        descuento = subtotalVenta * 0.08;
                    }else{
                        descuento = subtotalVenta * 0.10;
                    }
                    monto = subtotalVenta - descuento;
                    iva = monto * 0.12;
                    total = monto + iva;
                    
                    //metodo de pago
        System.out.println("====================================================");            
                    System.out.println("Seleccione su metodo de pago: \n"
                            + "1. Efectivo. \n"
                            + "2. Tarjeta. \n"
                            + "3. Transferencia");
        System.out.println("====================================================");            
                    metodoPago = tc.nextInt();
        System.out.println("====================================================");            
                    
                    switch (metodoPago){
                        case 1://Pago en efectivo
                            do {
                                System.out.println("Ingrese el efectivo recibido");
                            efectivo = tc.nextDouble();
                            if (efectivo < total){
                                System.out.println("El efectivo es insuficiente. \n"
                                        + "Ingrese nuevamente el efectivo recibido");
                                }   
                            }while (efectivo < total);
                            
                            //calculo del cambio
                            cambio = efectivo - total;
                            System.out.println("El cambio a entregar son: Q." + cambio);
                            //aumento del contador
                            pagosEfectivo = pagosEfectivo + 1;
                            
                            pagadoCon = 1;
                            
                            break;
                        case 2://Pago con tarjeta
                            System.out.println("Inserte la  tarjeta");
                            System.out.println("...");
                            System.out.println("...");
                            System.out.println("...");
                            System.out.println("La tarjeta fue aprovada?");
                            System.out.println("1. Si");
                            System.out.println("2. No");
                            aprobacion = tc.nextInt();
                            if (aprobacion == 1) {
                                pagosTarjeta = pagosTarjeta + 1;
                                pagadoCon = 2;
                                pagoMostrado = "Tarjeta";
                            } else if (aprobacion == 2){
                                System.out.println("Tarjeta rechazada.");
                                pagadoCon = 0;
                            }else {
                                System.out.println("Opcion invalida");
                            }                           
                            break;
                        case 3:
                            System.out.println("La trasnsferencia fue recibida?");
                            System.out.println("1. Si");
                            System.out.println("2. No");
                            aprobacion = tc.nextInt();
                            if (aprobacion == 1) {
                                pagosTransferencia = pagosTransferencia + 1;
                                pagadoCon = 3;
                                pagoMostrado = "Transferencia";
                            }else if (aprobacion == 2){
                                System.out.println("Transferencia invalida.");
                                pagadoCon = 0;
                            }else {
                                System.out.println("Opcion invalida");
                            }
                            break;
                            default:
                            System.out.println("Ingrese una opcion valida");
                            break;    
                    }
        System.out.println("====================================================");
        System.out.println("====================================================");
                    
                    if (pagadoCon != 0){
                       if (ventasCompletadas == 0) {
                           ventaMayor = total;
                           ventaMenor = total;
                       }else{
                           if (total > ventaMayor){
                                ventaMayor = total;
                            }
                            if (total < ventaMenor){
                                ventaMenor = total;
                            }
                       }
                        ventasCompletadas = ventasCompletadas + 1;
                        productosVendidos = productosVendidos + productosVenta;
                        totalVendido = totalVendido + total;
                    }
                    
                    //resumen
                    if (pagadoCon != 0) {
                        System.out.println("Resumen de venta.");
                        System.out.println("Cantidad de productos: " + cantidadProd);
                        System.out.println("Subtotal a pagar: Q." + subtotalVenta);
                        System.out.println("Descuento aplicado: " + descuento);
                        System.out.println("IVA de la venta: Q." + iva);
                        System.out.println("Total a pagar: Q." + total);
                        if (pagadoCon == 1) {
                        System.out.println("la forma de pago fue: Efectivo");
                        System.out.println("El pago recibido fue de: Q" + efectivo);
                        System.out.println("El cambio entregado fue de: Q" + cambio);
                    }else {
                        System.out.println("El metodo de pago fue: " + pagoMostrado);
                    }
                    } else{
                        System.out.println("La venta fue canselada");
                    }
        System.out.println("====================================================");                
                    break;
                case 2:
        System.out.println("====================================================");            
                    System.out.println("Consulta de compras");
        System.out.println("====================================================");
                    
                    System.out.println("Ventas realizadas: " + ventasCompletadas);
                    System.out.println("Cantidad de productos vendidos: " + productosVendidos);
                    System.out.println("El total vendido es de: Q." + totalVendido);
                    System.out.println("Ventas en efectivo: " + pagosEfectivo);
                    System.out.println("Ventas con tarjeta: " + pagosTarjeta);
                    System.out.println("Ventas por transferencia: " + pagosTransferencia);
        System.out.println("====================================================");            
                    
                    break;
                case 3:
        System.out.println("====================================================");            
                    System.out.println("Mostrando estadisticas");
        System.out.println("====================================================");
                    if (ventasCompletadas == 0){
                        System.out.println("No existen ventas registradas.");
        System.out.println("====================================================");                
                    }else {
                        double promedioVentas = totalVendido / ventasCompletadas;
                        System.out.println("Ventas totales: " + ventasCompletadas);
                        System.out.println("Cantidad de productos vendidos: " + productosVendidos);
                        System.out.println("Total de dinero por las ventas: " + totalVendido);
                        System.out.println("El promedio de ventas es de: Q." + promedioVentas);
                        System.out.println("Ventas en efectivo: " + pagosEfectivo);
                        System.out.println("Ventas con tarjeta: " + pagosTarjeta);
                        System.out.println("Ventas por transferencia: " + pagosTransferencia);
                        System.out.println("Venta de mayor valor: Q" + ventaMayor);
                        System.out.println("Venta de menor valor: Q" + ventaMenor);
                    }
        System.out.println("====================================================");
                    break;
                case 4:
        System.out.println("====================================================");            
                    System.out.println("Que tenga buen dia.");
        System.out.println("====================================================");            
                    break;
                default:
        System.out.println("====================================================");            
                    System.out.println("Opion no valida.");
        System.out.println("====================================================");            
                    break;
            }
        }while (op !=4);
    }
    
}