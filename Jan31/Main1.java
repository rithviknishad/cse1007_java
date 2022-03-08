package Jan31;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Customer {
    int customerNumber;
    String name;

    Customer(int customerNumber, String name) {
        this.customerNumber = customerNumber;
        this.name = name;
    }
}

class Membership {
    int memberNumber;
    int customerNumber;

    Membership(int memberNumber, int customerNumber) {
        this.memberNumber = memberNumber;
        this.customerNumber = customerNumber;
    }
}

class Cassette {
    int cassetteNumber;
    String cassetteName;
    String language;

    Cassette(int cassetteNumber, String cassetteName, String language) {
        this.cassetteNumber = cassetteNumber;
        this.cassetteName = cassetteName;
        this.language = language;
    }
}

class IssueRecord {
    int issueNumber;
    String issueDate;
    int memberNumber;
    int cassetteNumber;

    IssueRecord(int issueNumber, String issueDate, int memberNumber, int casseteNumber) {
        this.issueNumber = issueNumber;
        this.issueDate = issueDate;
        this.memberNumber = memberNumber;
        this.cassetteNumber = casseteNumber;
    }
}

public class Main1 {

    static void defaultInputs(List<Customer> customers, List<Membership> memberships, List<Cassette> cassettes,
            List<IssueRecord> issueRecords) {
        customers.add(new Customer(12, "John"));
        customers.add(new Customer(13, "Rohith"));
        customers.add(new Customer(14, "Karthik"));

        memberships.add(new Membership(120, 12));
        memberships.add(new Membership(130, 13));
        memberships.add(new Membership(140, 14));

        cassettes.add(new Cassette(1200, "Cassete 1", "Hinid"));
        cassettes.add(new Cassette(1300, "Cassete 2", "Hinid"));
        cassettes.add(new Cassette(1400, "Cassete 3", "Hinid"));

        issueRecords.add(new IssueRecord(412, "31-02-2019", 120, 1200));
        issueRecords.add(new IssueRecord(413, "31-02-2019", 130, 1300));
        issueRecords.add(new IssueRecord(414, "31-01-2019", 140, 1400));
    }

    public static Customer getCustomerFromMembership(int membershipNumber, List<Membership> memberships,
            List<Customer> customers) {

        int customerNumber = -1;

        for (Membership m : memberships) {
            if (m.memberNumber == membershipNumber) {
                customerNumber = m.customerNumber;
                break;
            }
        }

        for (Customer c : customers) {
            if (c.customerNumber == customerNumber) {
                return c;
            }
        }

        return null;
    }

    public static void listAllCustomerNamesAndMembershipNumbers(List<Customer> customers,
            List<Membership> memberships) {
        System.out.println("Listing all customer names with their membership numbers...");

        for (Customer customer : customers) {
            for (Membership membership : memberships) {
                if (customer.customerNumber == membership.customerNumber) {
                    System.out.println(customer.name + " (Membership# " + membership.memberNumber + ")");
                }
            }
        }
    }

    public static void listAllissueRecordsForMonth(int month, List<IssueRecord> issueRecords, List<Customer> customers,
            List<Cassette> cassettes, List<Membership> memberships) {
        System.out.println("Listing all issueRecords for given month with custom names and cassette names...");

        for (IssueRecord issue : issueRecords) {
            if (Integer.parseInt(issue.issueDate.split("-")[1]) == month) {
                Customer customer = getCustomerFromMembership(issue.memberNumber, memberships, customers);

                for (Cassette cassette : cassettes) {
                    if (cassette.cassetteNumber == issue.cassetteNumber) {
                        System.out.println("[Issue#" + issue.issueNumber + "] " + customer.name + " (Cassette: "
                                + cassette.cassetteName + ")");
                    }
                }
            }
        }
    }

    public static void listAllCustomersAndDateOfCassetteLanguage(String language, List<IssueRecord> issueRecords,
            List<Membership> memberships, List<Customer> customers, List<Cassette> cassettes) {
        List<Integer> cassetteNumbers = new ArrayList<>();

        for (Cassette cass : cassettes) {
            if (cass.language == language) {
                cassetteNumbers.add(cass.cassetteNumber);
            }
        }

        for (IssueRecord i : issueRecords) {
            if (cassetteNumbers.contains(i.cassetteNumber)) {
                Customer customer = getCustomerFromMembership(i.memberNumber, memberships, customers);
                System.out.println(i.issueDate + " " + customer.name);
            }
        }
    }

    public static void listAllMemberIDsAndTotalNumberOfCassettesTaken(List<Membership> memberships,
            List<IssueRecord> issueRecords) {
        for (Membership membership : memberships) {
            System.out.println(membership.memberNumber);
        }

        System.out.println("Total number of cassettes taken: " + issueRecords.size());
    }

    public static void displayCustomerNameCassetteNameIssueDateOfIssueNumber(int issueNumber, List<Customer> customers,
            List<Membership> memberships, List<Cassette> cassettes, List<IssueRecord> issueRecords) {

        for (IssueRecord issue : issueRecords) {
            if (issue.issueNumber == issueNumber) {
                Customer customer = getCustomerFromMembership(issue.memberNumber, memberships, customers);

                for (Cassette cass : cassettes) {
                    if (issue.cassetteNumber == cass.cassetteNumber) {
                        System.out.println(customer.name +
                                " (Cassette Name: " + cass.cassetteName + ") (Issued on: " + issue.issueDate + ")");
                    }
                }

                break;
            }
        }
    }

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        List<Membership> memberships = new ArrayList<>();
        List<Cassette> cassettes = new ArrayList<>();
        List<IssueRecord> issueRecords = new ArrayList<>();

        defaultInputs(customers, memberships, cassettes, issueRecords);

        listAllCustomerNamesAndMembershipNumbers(customers, memberships);

        Scanner in = new Scanner(System.in);

        System.out.print("Enter month number: ");
        int month = Integer.parseInt(in.nextLine().strip());
        listAllissueRecordsForMonth(month, issueRecords, customers, cassettes, memberships);

        System.out.println("Enter language: ");
        String language = in.nextLine().strip();
        listAllCustomersAndDateOfCassetteLanguage(language, issueRecords, memberships, customers, cassettes);

        listAllMemberIDsAndTotalNumberOfCassettesTaken(memberships, issueRecords);

        int issueNumber = Integer.parseInt(in.nextLine().strip());
        displayCustomerNameCassetteNameIssueDateOfIssueNumber(issueNumber, customers, memberships, cassettes,
                issueRecords);

        in.close();

    }
}