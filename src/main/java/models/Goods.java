package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import constants.JpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * 従業員データのDTOモデル
 *
 */
@Table(name = JpaConst.TABLE_GOODS)
@NamedQueries({
    @NamedQuery(
            name = JpaConst.Q_GOODS_GET_ALL,
            query = JpaConst.Q_GOODS_GET_ALL_DEF),
    @NamedQuery(
            name = JpaConst.Q_GOODS_COUNT,
            query = JpaConst.Q_GOODS_COUNT_DEF),
    @NamedQuery(
            name = JpaConst.Q_GOODS_COUNT_REGISTERED_BY_CODE,
            query = JpaConst.Q_GOODS_COUNT_REGISTERED_BY_CODE_DEF),
    @NamedQuery(
            name = JpaConst.Q_GOODS_GET_BY_CODE_AND_PASS,
            query = JpaConst.Q_GOODS_GET_BY_CODE_AND_PASS_DEF)
})

@Getter //全てのクラスフィールドについてgetterを自動生成する(Lombok)
@Setter //全てのクラスフィールドについてsetterを自動生成する(Lombok)
@NoArgsConstructor //引数なしコンストラクタを自動生成する(Lombok)
@AllArgsConstructor //全てのクラスフィールドを引数にもつ引数ありコンストラクタを自動生成する(Lombok)
@Entity
public class Goods {

    /**
     * id
     */

    @Id
    @Column(name = JpaConst.GOODS2_COL_ID,nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = JpaConst.EMP2_COL_ID,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employee_id;

    @Column(name = JpaConst.REP2_COL_ID,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer report_id;





}