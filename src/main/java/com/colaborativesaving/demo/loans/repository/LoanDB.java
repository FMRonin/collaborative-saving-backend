package com.colaborativesaving.demo.loans.repository;

import com.colaborativesaving.demo.loans.model.Loan;
import com.colaborativesaving.demo.users.repository.UserDB;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "loan")
public class LoanDB {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(optional = false)
    private UserDB user;

    @ManyToOne
    private LoanTypeDB loanType;

    @Column(name = "payment")
    private double payment;

    @Column(name = "installment_value")
    private double installmentValue;

    @Column(name = "total")
    private double total;

    @Column(name = "balance")
    private double balance;

    @Column(name = "total_installment")
    private int totalInstallments;

    @Column(name = "pendings_installment")
    private int pendingInstallments;

    @Column(name = "interest")
    private double interest;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserDB getUser() {
        return user;
    }

    public void setUser(UserDB user) {
        this.user = user;
    }

    public LoanTypeDB getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanTypeDB loanType) {
        this.loanType = loanType;
    }

    public double getInstallmentValue() {
        return installmentValue;
    }

    public void setInstallmentValue(double installmentValue) {
        this.installmentValue = installmentValue;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getTotalInstallments() {
        return totalInstallments;
    }

    public void setTotalInstallments(int totalInstallments) {
        this.totalInstallments = totalInstallments;
    }

    public int getPendingInstallments() {
        return pendingInstallments;
    }

    public void setPendingInstallments(int pendingInstallments) {
        this.pendingInstallments = pendingInstallments;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public Loan getLoan() throws Exception {
        Loan loan = new Loan();
        loan.setUser(this.user.getUser());
        loan.setTotal(this.total);
        loan.setBalance(this.balance);
        loan.setLoanType(this.loanType.getLoanType());
        loan.setInstallmentValue(this.installmentValue);
        loan.setPayment(this.payment);
        loan.setInterest(this.interest);
        loan.setPendingInstallments(this.pendingInstallments);
        loan.setTotalInstallments(this.totalInstallments);
        return loan;
    }

    public void setLoan(Loan loan) {
        this.balance = loan.getBalance();
        this.total = loan.getTotal();
        this.payment = loan.getPayment();
        this.installmentValue = loan.getInstallmentValue();
        this.totalInstallments = loan.getTotalInstallments();
        this.pendingInstallments = loan.getPendingInstallments();
    }
}
