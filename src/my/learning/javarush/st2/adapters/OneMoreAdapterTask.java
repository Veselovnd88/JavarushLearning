package my.learning.javarush.st2.adapters;

import java.util.HashMap;
import java.util.Map;

public class OneMoreAdapterTask {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
       countries.put("UA","Ukraine");
       countries.put("RU","Russia");
       countries.put("CA","Canada");
    }

    public static void task(){
        Customer c = new Customer() {
            @Override
            public String getCompanyName() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getCountryName() {
                return "Ukraine";
            }
        };
        Contact contact = new Contact() {
            @Override
            public String getName() {
                return "Ivanov, Ivan";
            }

            @Override
            public String getPhoneNumber() {
                return "+38(050)123-45-67";
            }
        };
        RowItem dA =new DataAdapter(c, contact);
        System.out.println(dA.getCompany());
        System.out.println(dA.getContactFirstName());
        System.out.println(dA.getDialString());
        System.out.println(dA.getContactLastName());
        System.out.println(dA.getCountryCode());


    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.contact = contact;
            this.customer = customer;
        }

        @Override
        public String getCountryCode() {

            String code=null;
            String country = customer.getCountryName();
            for (Map.Entry<String, String> entry: countries.entrySet()){
                if (entry.getValue().equals(country)){
                    code = entry.getKey();
                }
            }
            return code;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String [] parts = contact.getName().split(",");

            return parts[1].trim();
        }

        @Override
        public String getContactLastName() {
            String [] parts = contact.getName().split(",");

            return parts[0].trim();
        }

        @Override
        public String getDialString() {
            StringBuilder sb = new StringBuilder("callto://");

            sb.append(contact.getPhoneNumber().replaceAll("[)(-]",""));

            return sb.toString();
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }


}
