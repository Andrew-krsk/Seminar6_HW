public class Report {
    User user;

    public Report(User user) {
        this.user = user;
    }

    public void print(){

        System.out.println("Report for user: "+user.getName());
    }
}