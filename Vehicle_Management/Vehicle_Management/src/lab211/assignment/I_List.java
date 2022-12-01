package lab211.assignment;


public interface I_List {
  
    public boolean loadFromFile(String fileName);
    public boolean saveToFile(String fileName);
    public int searchId(String newId);
    public void addCar();
    public void addMotorbike();
    public void updateById();
    public void deleteById();
    public void searchById();
    public void searchByName();
    public void sortByBrand();
    public void printList();
    public void showAllByDescendingByPrice();
}
