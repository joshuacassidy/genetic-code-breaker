public class Population {

    private Member[] members;

    public Population(int populationSize) {
        this.members = new Member[populationSize];
        init();
    }

    public void init() {
        for (int i = 0; i < members.length; i++) {
            Member member = new Member();
            member.generateMember();
            saveIndividual(i, member);
        }
    }

    public Member getMember(int index) {
        return members[index];
    }

    public Member getFittestMember() {
        Member fittest = members[0];
        for (int i = 1; i < members.length; i++) {
            if (getMember(i).getFitness() >= fittest.getFitness()) {
                fittest = members[i];
            }
        }
        return fittest;
    }

    public int size() {
        return members.length;
    }

    public void saveIndividual(int index, Member member) {
        this.members[index] = member;
    }

    public String showFittestMember () {
        String genes = "";
        for (char gene : getFittestMember().getGenes()) {
            genes+=gene;
        }
        return genes;
    }

    public Member[] getMembers() {
        return members;
    }

    public int getFittestMemberFitness() {
        return getFittestMember().getFitness();
    }


}
