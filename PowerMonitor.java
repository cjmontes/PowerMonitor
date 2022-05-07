/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powermonitor;
import java.io.IOException;
/**
 *
 * @author carlos
 */
    /** CjMO 
     * 
     * Se usa la siguiente API , cuyos ficheros son :
     * RegisterAddress.java contiene un enum con los Nros de Registro del INA219
     *      Por ejemplo
     *      RegisterAddress regConf = RegisterAddress.CONGIGURATION;
     * interface INA219RegisterIF
     *      Interface Define las Funciones de Lectura/Escritura de Registros
     * I2CRegisterImpl
     *      Clase Implementa las funciones de  INA219RegisterIF
     *      El constructor recibe como argumento la dirección I2C del dispositivo
     *      y crea el device I2C, por medio de la funcion de Pi4j:
     *       device = I2CFactory.getInstance(I2CBus.BUS_1).getDevice(address.getValue());
     *      writeRegister: Escribe un Int sobre el registro que recibe como argumanto, el valor q recibe
     *      readRegister : Lee un Int del registro que recibe como argumento
     *      readSignedReguster : Lee un Int del registro que recibe como argumento
     * INA219Base
     *      El contructor recibe un objeto de tipo I2CRegisterImpl .con los parametros del dispositivo 
     *       public double getShuntVoltage()
     *       public double getBusVoltage()
     *       public double getPower()
     *       public doublre getCurrent()
     *       void configure _> configura el dispositivo
     * 
     * INA219 Extiende INA219Base y contiene enumeraciones 
     * 
     *
     
     *Ejecutar sin argumentos, redireccionado salida
     *La salida es: 
     *
     * <I> int </I>
     * <V> volt </V>
     */
    
 
    

public class PowerMonitor {

    /**
     * @param args the command line arguments
     */
    static INA219 ina219;
       
    public static void main(String[] args) {
        // TODO code application logic here
                try {
            ina219 = new INA219 ( INA219.Address.ADDR_40, 
                0.001,                                 // Shunt resist: 1 mili ohm  
                40.0,                                    // Max. expected current
                INA219.Brng.V16,                       // Voltage range
                INA219.Pga.GAIN_1,                     // 40 mV is full scale
                INA219.Adc.SAMPLES_32,                   // Vol. bus 32 Samples averag.
                INA219.Adc.SAMPLES_32        );         // Vol. shunt 32 samples averag.
            
            System.out.println("<V>"+  ina219.getBusVoltage()+"</V>");
            // System.out.println(" Power :"+  ina219.getPower() );
            // System.out.println(" Shunt Voltage:"+  ina219.getShuntVoltage() );
            System.out.println("<I>"+  ina219.getCurrent()+"</I>");
          
            
        }catch( IOException e ){
            e.printStackTrace();
        }
        
            
    }

        
        
    
    
}
