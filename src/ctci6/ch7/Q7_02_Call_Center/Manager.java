package ctci6.ch7.Q7_02_Call_Center;

class Manager extends Employee {
    public Manager(CallHandler callHandler) {
        super(callHandler);
        rank = Rank.Manager;
    }
}
