// Dependency Inversion Principle : 
// High-level modules should not depend on low-level modules. Both should depend on abstractions.
// Abstractions should not depend on details. Details should depend on abstractions.
// In this example, we have a recommendation system that can use different strategies for recommending content.
// The high-level module (RecommendationEngine) depends on the abstraction (RecommendationStrategy),
// not on the concrete implementations (RecentRecomendations, GenreRecomendations, TrendingRecomendations).
// This allows us to easily add new recommendation strategies without modifying the high-level module.

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
