
package actions.views;

import java.util.ArrayList;
import java.util.List;

import models.Goods;


public class GoodConverter {


    public static Goods toModel(GoodView ev) {

        return new Goods(
                ev.getId(),
                ev.getEmployee_id(),
                ev.getReport_id());

    }


    public static GoodView toView(Goods e) {

        if(e == null) {
            return null;
        }

        return new GoodView(
                e.getId(),
                e.getEmployee_id(),
                e.getReport_id());

    }



    public static List<GoodView> toViewList(List<Goods> list) {
        List<GoodView> evs = new ArrayList<>();

        for (Goods e : list) {
            evs.add(toView(e));
        }

        return evs;
    }


    public static void copyViewToModel(Goods e, Goods ev) {
        e.setId(ev.getId());
        e.setEmployee_id(ev.getEmployee_id());
        e.setReport_id(ev.getReport_id());

    }

}