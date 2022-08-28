package services;

import java.util.List;

import actions.views.EmployeeConverter;
import actions.views.EmployeeView;
import actions.views.GoodConverter;
import actions.views.GoodView;
import constants.JpaConst;
import models.Goods;


public class GoodService extends ServiceBase {


    public List<GoodView> getMinePerPage(EmployeeView employee, int page) {

        List<Goods> goods = em.createNamedQuery(JpaConst.Q_REP_GET_ALL_MINE, Goods.class)
                .setParameter(JpaConst.JPQL_PARM_EMPLOYEE, EmployeeConverter.toModel(employee))
                .setFirstResult(JpaConst.ROW_PER_PAGE * (page - 1))
                .setMaxResults(JpaConst.ROW_PER_PAGE)
                .getResultList();
        return GoodConverter.toViewList(goods);
    }


    public long countAllMine(EmployeeView employee) {

        long count = (long) em.createNamedQuery(JpaConst.Q_GOODS_COUNT_ALL_MINE, Long.class)
                .setParameter(JpaConst.JPQL_PARM_EMPLOYEE, EmployeeConverter.toModel(employee))
                .getSingleResult();

        return count;
    }


    public List<GoodView> getAllPerPage(int page) {

        List<Goods> goods = em.createNamedQuery(JpaConst.Q_GOODS_GET_ALL, Goods.class)
                .setFirstResult(JpaConst.ROW_PER_PAGE * (page - 1))
                .setMaxResults(JpaConst.ROW_PER_PAGE)
                .getResultList();
        return GoodConverter.toViewList(goods);
    }


    public long countAll() {
        long goods_count = (long) em.createNamedQuery(JpaConst.Q_GOODS_COUNT, Long.class)
                .getSingleResult();
        return goods_count;
    }

   public GoodView findOne(int Good) {
       return GoodConverter.toView(findOneInternal(Good));
   }

   public void create(GoodView ev) {

           createInternal(ev);
       }





//    public List<String> update(GoodView rv) {
//
//        List<String> errors = ReportValidator.validate(rv);
//
//        if (errors.size() == 0) {
//
//            LocalDateTime ldt = LocalDateTime.now();
//            rv.setUpdatedAt(ldt);
//
//            updateInternal(rv);
//        }
//
//        return errors;
//    }


    private Goods findOneInternal(int Good) {
        return em.find(Goods.class, Good);
    }


    private void createInternal(GoodView ev) {

        em.getTransaction().begin();
        em.persist(GoodConverter.toModel(ev));
        em.getTransaction().commit();

    }

}
//    private void updateInternal(GoodView ev) {
//
//        em.getTransaction().begin();
//        Goods e = findOneInternal(ev.getGoods());
//        GoodConverter.copyViewToModel(e,ev);
//        em.getTransaction().commit();
//
//    }
//
//}