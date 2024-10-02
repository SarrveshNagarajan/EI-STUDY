import java.util.ArrayList;
import java.util.List;

interface NewsSubscriber {
    void receiveNews(String news);
}

class NewsAgency {
    private List<NewsSubscriber> subscribers = new ArrayList<>();
    private String latestNews;

    public void addSubscriber(NewsSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(NewsSubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void setNews(String news) {
        this.latestNews = news;
        notifySubscribers();
    }

    private void notifySubscribers() {
        for (NewsSubscriber subscriber : subscribers) {
            subscriber.receiveNews(this.latestNews);
        }
    }
}

class NewsChannel implements NewsSubscriber {
    private String name;

    public NewsChannel(String name) {
        this.name = name;
    }

    @Override
    public void receiveNews(String news) {
        System.out.println(name + " received breaking news: " + news);
    }
}

public class NewsAgencyDemo {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();

        NewsChannel bbcNews = new NewsChannel("BBC News");
        NewsChannel cnnNews = new NewsChannel("CNN News");
        NewsChannel foxNews = new NewsChannel("Fox News");

        newsAgency.addSubscriber(bbcNews);
        newsAgency.addSubscriber(cnnNews);
        newsAgency.addSubscriber(foxNews);

        newsAgency.setNews("Breaking: Major earthquake hits capital city!");
        
        newsAgency.removeSubscriber(foxNews);
        
        newsAgency.setNews("Update: Rescue efforts underway after earthquake.");
    }
}