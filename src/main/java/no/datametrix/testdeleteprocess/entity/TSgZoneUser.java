package no.datametrix.testdeleteprocess.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Entity
@NoSql(dataFormat = DataFormatType.MAPPED,dataType = "tsgzoneusers")
public class TSgZoneUser implements Serializable {
    private static final long serialVersionUID = 8161651080980048148L;

    @Id
    @GeneratedValue
    @Field(name = "_id")
    private String id;
    @Basic
    @Field(name = "name")
    private String name;

    public TSgZoneUser() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
