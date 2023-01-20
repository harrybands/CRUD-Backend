package com.example.demo.repository;

import com.example.demo.DTO.EmployeesDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

@Repository
public class TestRepositoryImpl implements TestRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    public String getData() {
        return "aaaa";
    }
//    ADDRESS as address, GENDER as gender, FULL_NAME as fullName, CREATE_DATE as createDate," +
//            "UPDATE_DATE as updateDate, STATUS as status

    // select * from information_training where 1=1 and lower (FULL_NAME) like lower ('%d%');

    public List<EmployeesDTO> getEmployeeData(String name) {
        StringBuilder sql = new StringBuilder();
        List<EmployeesDTO> res = new ArrayList<>();
        sql.append("select * from information_training");
        sql.append(" where 1=1");
        if (name != null && !name.isEmpty()) {
            sql.append(" and lower(FULL_NAME) like lower (:name)");
            System.out.println("sql");
        }
        Query nativeSql = entityManager.createNativeQuery(sql.toString());
        if (name != null && !name.isEmpty()) {
            nativeSql.setParameter("name", "%" + name + "%");
            System.out.println(nativeSql + "sql");
        }
        List<Object[]> objects = nativeSql.getResultList();


//        [DisplayFormat(DataFormatString = "{0:yyyy-MM-dd}", ApplyFormatInEditMode = true)]
//        String date_s = " 2011-01-18 00:00:00.0";
//        SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
//        Date date = dt.parse(date_s, 2);
//        SimpleDateFormat dt1 = new SimpleDateFormat("yyyyy-mm-dd");
//        System.out.println(dt1.format(date));

        for (Object[] objects1 : objects) {
            EmployeesDTO dto = new EmployeesDTO();
                dto.setId(valueOf((objects1[7])));
                dto.setFullName(valueOf((objects1[1])));
                dto.setAddress(valueOf((objects1[2])));
                dto.setGender(valueOf((objects1[3])));
                dto.setCreateDate(valueOf((objects1[4])));
                dto.setUpdateDate(valueOf((objects1[5])));
                dto.setStatus(valueOf((objects1[6])));
                res.add(dto);
        }
        return res;
    }

}
