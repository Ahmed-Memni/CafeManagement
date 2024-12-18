package com.cafe.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class ALL {
    private List<Inventory> inv;
    private List<Administrator> adm;
    private List<Chef> chefs;
    private List<Customer> custs;
    private List<Feedback> feedbacks;
    private List<Order> orders;
    private List<OrderItem> items;
    private List<Report> reports;
    private List<Server> servers;
    private List<Supplier> suppliers;
    private List<Stock> stocks;

    // Constructeur par défaut : initialisation des listes à des ArrayList vides
    public ALL() {
        this.inv = new ArrayList<>();
        this.adm = new ArrayList<>();
        this.chefs = new ArrayList<>();
        this.custs = new ArrayList<>();
        this.feedbacks = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.items = new ArrayList<>();
        this.reports = new ArrayList<>();
        this.servers = new ArrayList<>();
        this.suppliers = new ArrayList<>();
        this.stocks = new ArrayList<>();
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    // Remplacer un Chef
    public void replaceChef(Chef oldChef, Chef newChef) {
        int index = chefs.indexOf(oldChef);
        if (index != -1) {
            chefs.set(index, newChef);
        }
    }

    // Remplacer un Client
    public void replaceCustomer(Customer oldCustomer, Customer newCustomer) {
        int index = custs.indexOf(oldCustomer);
        if (index != -1) {
            custs.set(index, newCustomer);
        }
    }

    // Remplacer un Feedback
    public void replaceFeedback(Feedback oldFeedback, Feedback newFeedback) {
        int index = feedbacks.indexOf(oldFeedback);
        if (index != -1) {
            feedbacks.set(index, newFeedback);
        }
    }

    // Remplacer une Commande
    public void replaceOrder(Order oldOrder, Order newOrder) {
        int index = orders.indexOf(oldOrder);
        if (index != -1) {
            orders.set(index, newOrder);
        }
    }

    // Remplacer un Article de commande
    public void replaceOrderItem(OrderItem oldItem, OrderItem newItem) {
        int index = items.indexOf(oldItem);
        if (index != -1) {
            items.set(index, newItem);
        }
    }

    // Remplacer un Rapport
    public void replaceReport(Report oldReport, Report newReport) {
        int index = reports.indexOf(oldReport);
        if (index != -1) {
            reports.set(index, newReport);
        }
    }

    // Remplacer un Serveur
    public void replaceServer(Server oldServer, Server newServer) {
        int index = servers.indexOf(oldServer);
        if (index != -1) {
            servers.set(index, newServer);
        }
    }

    // Remplacer un Fournisseur
    public void replaceSupplier(Supplier oldSupplier, Supplier newSupplier) {
        int index = suppliers.indexOf(oldSupplier);
        if (index != -1) {
            suppliers.set(index, newSupplier);
        }
    }
    // Getters et Setters pour chaque champ
    public List<Inventory> getInv() {
        return inv;
    }

    public List<Stock> getStocks() {return stocks;}
    public void setInv(List<Inventory> inv) {
        this.inv = inv;
    }

    public List<Administrator> getAdm() {
        return adm;
    }

    public void setAdm(List<Administrator> adm) {
        this.adm = adm;
    }

    public List<Chef> getChefs() {
        return chefs;
    }

    public void setChefs(List<Chef> chefs) {
        this.chefs = chefs;
    }

    public List<Customer> getCusts() {
        return custs;
    }

    public void setCusts(List<Customer> custs) {
        this.custs = custs;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public List<Server> getServers() {
        return servers;
    }

    public void setServers(List<Server> servers) {
        this.servers = servers;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }
    public void deleteChef(int index) {
        if (index >= 0 && index < chefs.size()) {
            chefs.remove(index);
            System.out.println("Chef removed successfully.");
        } else {
            System.out.println("Invalid index. No Chef was removed.");
        }
    }

    // Method to delete a Customer by index
    public void deleteCustomer(int index) {
        if (index >= 0 && index < custs.size()) {
            custs.remove(index);
            System.out.println("Customer removed successfully.");
        } else {
            System.out.println("Invalid index. No Customer was removed.");
        }
    }

    // Method to delete a Server by index
    public void deleteServer(int index) {
        if (index >= 0 && index < servers.size()) {
            servers.remove(index);
            System.out.println("Server removed successfully.");
        } else {
            System.out.println("Invalid index. No Server was removed.");
        }
    }



    //function find customer from the list
public Customer findCustomerByName(String name) {
    if (name == null || custs == null) {
        return null; // Retourne null si le nom ou la liste des clients est null
    }
    for (Customer customer : custs) {
        if (name.equals(customer.getNom())) {
            return customer; // Retourne le client correspondant
        }
    }
    return null; // Retourne null si aucun client n'est trouvé
}

// Add and Remove methods for Administrator
    public void addAdministrator(Administrator administrator) {
        this.adm.add(administrator);
    }

    public void removeAdministrator(Administrator administrator) {
        this.adm.remove(administrator);
    }

    // Add and Remove methods for Chef
    public void addChef(Chef chef) {
        this.chefs.add(chef);
    }

    public void removeChef(Chef chef) {
        this.chefs.remove(chef);
    }

    // Add and Remove methods for Customer
    public void addCustomer(Customer customer) {
        this.custs.add(customer);
    }

    public void removeCustomer(Customer customer) {
        this.custs.remove(customer);
    }

    // Add and Remove methods for Feedback
    public void addFeedback(Feedback feedback) {
        this.feedbacks.add(feedback);
    }

    public void removeFeedback(Feedback feedback) {
        this.feedbacks.remove(feedback);
    }

    // Add and Remove methods for Order
    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public void removeOrder(Order order) {
        this.orders.remove(order);
    }

    // Add and Remove methods for OrderItem
    public void addOrderItem(OrderItem item) {
        this.items.add(item);
    }

    public void removeOrderItem(OrderItem item) {
        this.items.remove(item);
    }

    // Add and Remove methods for Report
    public void addReport(Report report) {
        this.reports.add(report);
    }

    public void removeReport(Report report) {
        this.reports.remove(report);
    }

    // Add and Remove methods for Server
    public void addServer(Server server) {
        this.servers.add(server);
    }

    public void removeServer(Server server) {
        this.servers.remove(server);
    }

    // Add and Remove methods for Supplier
    public void addSupplier(Supplier supplier) {
        this.suppliers.add(supplier);
    }

    public void removeSupplier(Supplier supplier) {
        this.suppliers.remove(supplier);
    }
}
