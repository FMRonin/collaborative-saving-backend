package com.colaborativesaving.demo.loans.repository;

import com.colaborativesaving.demo.loans.model.LoanType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "loan_type")
public class LoanTypeDB {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name", unique = true)
    private String loanTypeName;

    @Column(name = "min_installment_value")
    private double minInstallmentValue;

    @Column(name = "max_number_installments")
    private int maxNumberInstallments;

    @Column(name = "interest")
    private double interest;

    public LoanTypeDB(LoanType loanType) {
        this.interest = loanType.getInterest();
        this.loanTypeName = loanType.getLoanTypeName();
        this.maxNumberInstallments = loanType.getMaxNumberInstallments();
        this.minInstallmentValue = loanType.getMinInstallmentValue();
    }

    public LoanTypeDB(){}

    public void setLoanType(LoanType loanType){
        this.interest = loanType.getInterest();
        this.loanTypeName = loanType.getLoanTypeName();
        this.maxNumberInstallments = loanType.getMaxNumberInstallments();
        this.minInstallmentValue = loanType.getMinInstallmentValue();
    }

    public LoanType getLoanType(){
        LoanType loanType = new LoanType();
        loanType.setLoanTypeName(this.loanTypeName);
        loanType.setMaxNumberInstallments(this.maxNumberInstallments);
        loanType.setMinInstallmentValue(this.minInstallmentValue);
        loanType.setInterest(this.interest);
        return loanType;
    }

    public String getLoanTypeName() {
        return loanTypeName;
    }

    public void setLoanTypeName(String loanTypeName) {
        this.loanTypeName = loanTypeName;
    }

    public double getMinInstallmentValue() {
        return minInstallmentValue;
    }

    public void setMinInstallmentValue(double minInstallmentValue) {
        this.minInstallmentValue = minInstallmentValue;
    }

    public int getMaxNumberInstallments() {
        return maxNumberInstallments;
    }

    public void setMaxNumberInstallments(int maxNumberInstallments) {
        this.maxNumberInstallments = maxNumberInstallments;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
