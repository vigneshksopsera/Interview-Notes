 class Agency {
    String name;

    List<List<Agent>> heirarchy;
    List<Policy> policies;
    List<Plan> plans;

    Agency(String name, List<List<Agent>> heirarchy, List<Policy> policies, List<Plan> plans) {
      this.name = name;
      this.heirarchy = heirarchy;
      this.policies = policies;
      this.plans = plans;
    }

    void setComissionForAgent(Agent agent, int commision) {
      agent.commision = commision;
    }

    Integer getCommissionForAgent(Agent agent) {
      return agent.commision;
    }

    void sellPolicy(Agent agent, Policy policy, Plan plan, List<Agent> heirarchy) {
      // print commision of agent and other h members

    }
  }

  class Agent {
    String name;
    String type; //normal, super
    Integer commision; //0%

    Agent(String name, String type, Integer commision) {
      this.name = name;
      this.type = type;
      this.commision = commision;
    }
  }

  class Policy {
    String name;
    float faceValue;

    Policy(String name, float faceValue) {
      this.name = name;
      this.faceValue = faceValue;
    }
  }

  class Plan {
    String name;
    Map<Integer, Integer> superCommission;

    Plan(String name, Map<Integer, Integer> superCommission) {

      this.name = name;
      this.superCommission = superCommission;
    }

  }

class Solution {



  public static void main(String[] args) {

    Agent bob = new Agent("bob", "normal", 0);
    Agent x = new Agent("X", "super", 0);
    Agent a = new Agent("A", "super", 0);
    Agent c = new Agent("C", "super", 0);

    List<Agent> h1 = List.of(bob, x, a, c);

    List<List<Agent>> totalHierarchies = new ArrayList<>();
    totalHierarchies.add(h1);

    Policy policy1 = new Policy("policy1", 100000);
  
    List<Policy> policies = new ArrayList<>();
    policies.add(policy1);
    
    Map<Integer, Integer> superCommission = new HashMap<>();
    superCommission.put(0, 50);
    superCommission.put(1, 5);
    superCommission.put(2, 0);

    Plan p1anA = new Plan("plan1", superCommission);
        
    List<Plan> plans = new ArrayList<>();
    plans.add(p1anA);

    Agency agency = new Agency("VKS", totalHierarchies, policies, plans);

    agency.setComissionForAgent(bob, 2);
    agency.setComissionForAgent(x, 3);
    agency.setComissionForAgent(a, 4);
    agency.setComissionForAgent(c, 5);

    agency.sellPolicy(bob, policy1, p1anA, h1);

  }
}

