interface RecommendationStrategy{
    void recomend();
}

class RecentRecomendations implements RecommendationStrategy {
    public void recomend(){
        System.out.println("Showing recently added content...");
    }
}

class GenreRecomendations implements RecommendationStrategy {
    public void recomend(){
        System.out.println("Showing content based on your favorite genres...");
    }
}

class TrendingRecomendations implements RecommendationStrategy {
    public void recomend(){
        System.out.println("Showing trending content...");
    }
}


class RecommendationEngine {
    private RecommendationStrategy strategy;
    public RecommendationEngine(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }

    public void recomend() {
        strategy.recomend();
    }
} 
public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        RecommendationStrategy strategy = new TrendingRecomendations(); // could also be RecentlyAdded or GenreBased
        RecommendationEngine engine = new RecommendationEngine(strategy);
        engine.recomend();
    }
}
