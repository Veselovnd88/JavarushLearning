package my.learning.javarush.st2;

public class AdaptersTask {
    public static void task(){
        ATable aTable = new ATable() {
            @Override
            public String getCurrentUserName() {
                return "Amigo";
            }

            @Override
            public String getTableName() {
                return "DashboardTable";
            }
        };

        BTable table = new TableAdapter(aTable);
        System.out.println(table.getHeaderText());
    }
    public static class TableAdapter implements BTable {
        private ATable aTable;
        public TableAdapter(ATable atable){
            this.aTable = atable;
        }


        @Override
        public String getHeaderText() {
            return "["+aTable
                    .getCurrentUserName()+"]:"+ aTable.getTableName();
        }
    }

    public interface ATable {
        String getCurrentUserName();

        String getTableName();
    }

    public interface BTable {
        String getHeaderText();
    }


}
