public abstract class Data<T> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected void displayList(T[] list) {
        for (T item : list)
            System.out.println(item.toString());
    }
}
