import java.net.*;
import java.io.*;
 
public class Whois {
         public static void main (String [] args) throws IOException {
               WhoisClient whoisClient = new WhoisClient() ;
                whoisClient.connect(WhoisClient.DEFAULT_HOST) ;
                //whoisClient.connect(“whois.denic.de”) ;

                 String whois = whoisClient.query(“spreadshirt.com”) ;
   
                 WhoisRecord record = parse(whois) ;

                  System.out.println(whois) ;
                  System.out.println(record) ;

                  whoisClient.disconnect() ;
            }

            public static WhoisRecord parse(String Whois) {
                     Scanner scanner = new Scanner(whois) ;

                     WhoisRecord record = new WhoisRecord() ;
                      while (scanner.hasNextLine()) {
                              String line = scanner.nextLine().trim() ;
           
               String[] parts = line.split(“:”) ;
               if (parts.length == 2) {
                   final String key = parts[0].trim() ;
                   final String value = parts[1].trim() ;
                   switch (key) {
                       case “Server Name” ;
                              record.serverName = value ;
                              break ;
                         case “Domain Name” ;
                              record.domainName = value ;
                              break ;
                         case “”Registrar” ;
                              record.registrar = value ;
                              break ;
                         case “Name Server” ;
                              record.nameServer.add(value) ;
                              break ;
                         case “Sponsoring Registrar IANA ID” ;
                         case “Whois Server” ;
                         case “Referral URL” ;
                         case “Status : ” ;
                         case “Updated Date” ;
                         case “Creation Date” ;
                         case “Expiration Date” ;
                               break ;

                         default ;
                               break ;
                       }
                  }
              }
              return record ;
          }
   
          Public static class WhoisRecord {
                String serverName ;
                String domainName ;
                String registrar ;
                List<String> nameserver = new ArrayList<>() ;
  
                @Override
                public String toString() {
                     return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE)STYLE) ;
                }
            }
 }
                 
