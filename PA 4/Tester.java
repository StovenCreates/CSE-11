public class Tester {
    public static void main(String[] args) {
        User u1 = new User("CSE11Student");
        User u2 = new User("AnotherUser");

        Post p1 = new Post("Title", "Content", u1);
        Post c1 = new Post("Comment", p1, u1);

        System.out.println(p1);
        System.out.println(c1);

        u1.addPost(p1);
        u1.addPost(c1);
        System.out.println("Karma after adding posts: " + u1.getKarma());

        System.out.println("Top Post: " + u1.getTopPost());
        System.out.println("Top Comment: " + u1.getTopComment());

        u2.upvote(p1);
        System.out.println("Karma after upvoting p1: " + u1.getKarma());
        System.out.println("Upvoted p1: " + p1);

        u2.downvote(c1);
        System.out.println("Karma after downvoting c1: " + u1.getKarma());
        System.out.println("Downvoted c1: " + c1);

        System.out.println("Thread for c1: " + c1.getThread());

        u1.upvote(p1);
        u2.upvote(p1);
        u2.downvote(p1);
        System.out.println("Karma after upvote/downvote tests: " + u1.getKarma());

        System.out.println(u1);
    }
}
