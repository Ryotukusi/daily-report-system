package actions;

import java.io.IOException;

import javax.servlet.ServletException;

import actions.views.EmployeeView;
import actions.views.GoodView;
import constants.AttributeConst;
import constants.ForwardConst;
import constants.MessageConst;
import services.GoodService;
public class GoodAction extends ActionBase {

    private GoodService service;
    @Override
    public void process() throws ServletException, IOException {

        service = new GoodService();


        invoke();
        service.close();



    }






    public void doPostGood() throws ServletException, IOException {

        EmployeeView ev = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);

       int id= ev.getId();

        GoodView rv = new GoodView();
        putRequestScope(AttributeConst.LOGIN_EMP, rv);
        putRequestScope(AttributeConst.REP_ID, rv);

        rv.setReport_id(toNumber(getRequestParam(AttributeConst.REP_ID)));;
        rv.setEmployee_id(id);
        GoodView z = service.findOne(id);

        if(z==null){

            service.create(rv);


            redirect(ForwardConst.ACT_REP, ForwardConst.CMD_SHOW,(toNumber(getRequestParam(AttributeConst.REP_ID) )));





        }else {

            System.out.println("good");
            putSessionScope(AttributeConst.FLUSH, MessageConst.I_GOOD.getMessage());
            redirect(ForwardConst.ACT_REP, ForwardConst.CMD_SHOW,(toNumber(getRequestParam(AttributeConst.REP_ID) )));
            //        find　　グッドテーブルを検索
//
//        if登録されていればエラー
//
//
//        else登録されていなければ、
//        登録
//        フラッシュメッセージレポートあくしょんクラスのクリエイトメソッドを参考
//
//
//
//



        }


//      EmployeeView ev = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);
//
//      LocalDate day = null;
//      day = LocalDate.parse(getRequestParam(AttributeConst.REP_DATE));
//      ReportView rv = new ReportView(
//              null,
//              ev,
//              day,
//              getRequestParam(AttributeConst.REP_TITLE),
//              getRequestParam(AttributeConst.REP_CONTENT),
//              null,
//              null);




        //        EntityManager em = DBUtil.createEntityManager();
//        em.getTransaction().begin();
//
//        em.persist(em);
//        em.getTransaction().commit();


        //        String _token=(String)request.getParameter("_token");
//
//        EntityManager em = DBUtil.createEntityManager();
//
//        Goods r = em.find(Goods.class,Integer.valueOf(request.getParameter("report_id")));
//

//         int i = r.getReport_id();
//
//         r.setReport_id(i);
//         em.getTransaction().begin();
//         em.getTransaction().commit();
//         em.close();
}}
