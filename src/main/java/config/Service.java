package config;
public class Service {

        public String endpoint(String request){
                return"http://207.154.234.168:8888"+request;
        }
        
        public static String REGISTER= "/v1/register";
        
        public static String AUTHORIZE= "/v1/authorize";
        
}