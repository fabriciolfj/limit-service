package com.github.fabriciolfj.providers.database.data;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntityBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@MongoEntity(collection = "limit")
public class LimitData extends ReactivePanacheMongoEntityBase {

    @BsonId
    private ObjectId id;
    private String account;
    private int withdrawal;
    private BigDecimal rate;
    private BigDecimal value;
    private BigDecimal overdraft;
}
