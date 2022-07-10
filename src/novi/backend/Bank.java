package novi.backend;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Branch> branches = new ArrayList<Branch>();

    // add new branch
    public boolean addBranch(String location) {
        if(findBranch(location) >= 0) {
            System.out.println("Branch already exists");
            return false;
        } else {
            Branch branch = Branch.createBranch(location);
            this.branches.add(branch);
            return true;
        }
    }

    // show branches
    public void printBranches() {
        for(int i = 0; i < this.branches.size(); i++) {
            System.out.println(i+1 + ". " + this.branches.get(i).getLocation());
        }
    }

    // find branch
    private int findBranch(String location) {
        for(int i = 0; i < this.branches.size(); i++) {
            Branch branch = this.branches.get(i);
            if(branch.getLocation().equals(location)) {
                return i;
            }
        }
        return -1;
    }

    public Branch queryBranches(String location) {
        int position = findBranch(location);

        if(position < 0) {
            return null;
        } else {
            Branch branch = branches.get(position);
            return branch;
        }
    }

    // create bank
    public static Bank createBank() {
        return new Bank();
    }
}
