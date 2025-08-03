package mypojos;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String holderName;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Transaction> transactions = new ArrayList<>();

    // Constructors
    public Account() {}

    public Account(String holderName) {
        this.holderName = holderName;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction tx) {
        tx.setAccount(this); // set the parent reference
        transactions.add(tx);
    }

    public void removeTransaction(Transaction tx) {
        transactions.remove(tx);
        tx.setAccount(null); // break the link
    }
}
