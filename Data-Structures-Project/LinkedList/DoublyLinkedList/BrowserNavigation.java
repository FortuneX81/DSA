class Page {
    String url;
    Page next;
    Page prev;

    public Page(String url) {
        this.url = url;
    }
}

public class BrowserNavigation {

    Page current;

    public void visit(String url) {
        Page newPage = new Page(url);

        if (current != null) {
            current.next = newPage;
            newPage.prev = current;
        }

        current = newPage;
        System.out.println("Visited: " + url);
    }

    public void goBack() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Back to: " + current.url);
        }
    }

    public void goForward() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Forward to: " + current.url);
        }
    }

    public static void main(String[] args) {
        BrowserNavigation browser = new BrowserNavigation();
        browser.visit("google.com");
        browser.visit("youtube.com");
        browser.goBack();
        browser.goForward();
    }
}