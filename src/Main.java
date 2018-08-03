public class Main {


    public static void main(String[] args) {

        CodeBreaker codeBreaker = new CodeBreaker();
        Population population = new Population(100);
        int generation;
        for (generation = 0; population.getFittestMember().getFitness() != Keys.MAX_FITNESS ; generation++) {

            String generationResults = String.format("Generation %s The fittest member is: {%s} and has a fitness of %s \n", generation, population.showFittestMember(), population.getFittestMemberFitness());

            System.out.println(generationResults);

            population = codeBreaker.evolvePopulation(population);

        }

        System.out.println(String.format("\n\nThe final generation is %s. The fittest member is: {%s} and has a fitness of %s\n", generation, population.showFittestMember(), population.getFittestMemberFitness()));

    }

}
