public class News implements INews {
    private int id;
    private String title;
    private String publishDate;
    private String author;
    private String content;
    private float averageRate;
    private int[] rateList = new int[3];

    public News() {
        this.averageRate = 0.0f;
    }

    public News(int id, String title, String publishDate, String author, String content) {
        this.id = id;
        this.title = title;
        this.publishDate = publishDate;
        this.author = author;
        this.content = content;
        this.averageRate = 0.0f;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getAverageRate() {
        return averageRate;
    }

    public int[] getRateList() {
        return rateList;
    }

    public void setRateList(int[] rateList) {
        if (rateList.length == 3) {
            this.rateList = rateList;
            calculate();
        } else {
            System.out.println("rateList must have 3 elements!");
        }
    }


    public void setRate(int index, int rate) {
        if (index >= 0 && index < 3) {
            this.rateList[index] = rate;
            calculate();
        } else {
            System.out.println("Rate must be between 0 and 2!");
        }
    }

    public void calculate() {
        int sum = 0;
        for (int rate : rateList) {
            sum += rate;
        }
        this.averageRate = (float) sum / 3;
    }

    @Override
    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Publish date: " + publishDate);
        System.out.println("Author: " + author);
        System.out.println("Content: " + content);
        System.out.println("Average rate: " + String.format("%.2f", averageRate));
    }


}
