package com.kameleoon.quote.to;

import com.kameleoon.quote.domain.abstracts.HasId;
import lombok.AccessLevel;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public abstract class BaseTo implements HasId {

    protected Integer id;

    @Override
    public String toString() {
        return getClass().getSimpleName() + ":" + id;
    }
}
