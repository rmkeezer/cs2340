package spacetrader.data;

/**
 * Types of goods that are tradable.
 * 
 * @author Bao
 */
public enum Item {
    WATER(0, "Water", 0, 0, 2, 30, 3, 4, RadicalEvent.DROUGHT, Resource.LOTSOFWATER, Resource.DESERT, 30, 50),
    FURS(1, "Furs", 0 , 0, 0, 250, 10, 10, RadicalEvent.COLD, Resource.RICHFAUNA, Resource.LIFELESS, 230, 280),
    FOOD(2, "Food", 1, 0, 1, 100, 5, 5, RadicalEvent.CROPFAIL, Resource.RICHSOIL, Resource.POORSOIL, 90, 160),
    ORE(3, "Ore", 2, 2, 3, 350, 20, 10, RadicalEvent.WAR, Resource.MINERALRICH, Resource.MINERALPOOR, 350, 420),
    GAMES(4, "Games", 3, 1, 6, 250, -10, 5, RadicalEvent.BOREDOM, Resource.ARTISTIC, null, 160, 270),
    FIREARMS(5, "Firearms", 3, 1, 5, 1250, -75, 100, RadicalEvent.WAR, Resource.WARLIKE, null, 600, 1100),
    MEDICINE(6, "Medicine", 4, 1, 6, 650, -20, 10, RadicalEvent.PLAGUE, Resource.LOTSOFHERBS, null, 400, 700),
    MACHINES(7, "Machines", 4, 3, 5, 900, -30, 5, RadicalEvent.LACKOFWORKERS, null, null, 600, 800),
    NARCOTICS(8, "Narcotics", 5, 0, 5, 3500, -125, 150, RadicalEvent.BOREDOM, Resource.WEIRDMUSHROOMS, null, 2000, 3000),
    ROBOTS(9, "Robots", 6, 4, 7, 5000, -150, 100, RadicalEvent.LACKOFWORKERS, null, null, 3500, 5000);
    
    private final int key;
    private final String name;
    private final int mtlp;
    private final int mtlu;
    private final int ttp;
    private final int basePrice;
    private final int ipl;
    private final int var;
    private final RadicalEvent ie;
    private final Resource cr;
    private final Resource er;
    private final int mtl;
    private final int mth;
    
    
    private Item(int i, String d, int mtlp, int mtlu, int ttp, int base, int ipl, int var, RadicalEvent ie, Resource cr, Resource er, int mtl, int mth) {
        this.key = i;
        this.name = d;
        this.mtlp = mtlp;
        this.mtlu = mtlu;
        this.ttp = ttp;
        this.basePrice = base;
        this.ipl = ipl;
        this.var = var;
        this.ie = ie;
        this.cr = cr;
        this.er = er;
        this.mtl = mtl;
        this.mth = mth;
    }

    public int getValue() {
        return key;
    }
    
    public String getName() {
        return name;
    }

    public int getKey() {
        return key;
    }

    public int getMtlp() {
        return mtlp;
    }

    public int getMtlu() {
        return mtlu;
    }

    public int getTtp() {
        return ttp;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public int getIpl() {
        return ipl;
    }

    public int getVar() {
        return var;
    }

    public RadicalEvent getIe() {
        return ie;
    }

    public Resource getCr() {
        return cr;
    }

    public Resource getEr() {
        return er;
    }

    public int getMtl() {
        return mtl;
    }

    public int getMth() {
        return mth;
    }
    
}

