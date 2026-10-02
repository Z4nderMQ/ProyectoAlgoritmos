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
        double subtotalProd;
        double descuento = 0;
        double monto;
        double iva;
        double total;
        int metodoPago;
        double efectivo = 0;
        double cambio = 0;
        
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
                    
                    //Ingreso de informacion de los productos
        System.out.println("====================================================");
                    double subtotalVenta = 0;
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
                        System.out.println("Unidades del producto:");
                        unidadesProd = tc.nextInt();
                        
                        //Calcular los subtotales
                        subtotalProd = precioProd * unidadesProd;
                        subtotalVenta = subtotalVenta + subtotalProd;
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
                            break;
                        case 2://Pago con tarjeta
                            total = total;
                            break;
                        case 3:
                            total = total;
                            break;
                    }
                    //resumen
        System.out.println("====================================================");
        System.out.println("====================================================");
                    System.out.println("Resumen de venta.");
                    System.out.println("Cantidad de productos: " + cantidadProd);
                    System.out.println("Subtotal de venta: Q." + subtotalVenta);
                    System.out.println("Descuento aplicado: " + descuento);
                    System.out.println("IVA de la venta: Q." + iva);
                    System.out.println("Total de la venta: Q." + total);
                    System.out.println("Metodo de pago. " + metodoPago);
                    if(metodoPago == 1){
                        System.out.println("El efectivo recibio fue de: Q." + efectivo);
                        System.out.println("EL cambio fue de: Q." + cambio);
        System.out.println("====================================================");                
                    }
                    break;
                case 2:
                    System.out.println("Consulte su compra");
                    break;
                case 3:
                    System.out.println("Mostrando estadisticas");
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
