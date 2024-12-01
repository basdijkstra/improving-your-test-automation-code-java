package loans;

public class LoanRequest {

    private int loanAmount;
    private int downPayment;
    private String firstName;
    private String lastName;

    public LoanRequest(int loanAmount, int downPayment, String firstName, String lastName) {
        this.loanAmount = loanAmount;
        this.downPayment = downPayment;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(int downPayment) {
        this.downPayment = downPayment;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
