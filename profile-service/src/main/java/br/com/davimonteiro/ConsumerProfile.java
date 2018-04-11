package br.com.davimonteiro;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

import static br.com.davimonteiro.RetentionStrategy.EmailType.*;
import static br.com.davimonteiro.RetentionStrategy.PackageType.*;
import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
public class ConsumerProfile {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private Long consumerId;

    @Enumerated(EnumType.STRING)
    private Profile profile;

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public enum Profile {

        NEW_INVESTOR("New investor",
                new RetentionStrategy(WELCOME_EMAIL, WELCOME_PACKAGE)),
        CONSERVATIVE("Conservative",
                new RetentionStrategy(CONSERVATIVE_PROMOTIONAL_EMAIL, CONSERVATIVE_PROMOTIONAL_PACKAGE)),
        MODERATELY_CONSERVATIVE("Moderately conservative",
                new RetentionStrategy(MODERATELY_CONSERVATIVE_PROMOTIONAL_EMAIL, MODERATELY_CONSERVATIVE_PROMOTIONAL_PACKAGE)),
        BALANCED("Balanced",
                new RetentionStrategy(BALANCED_PROMOTIONAL_EMAIL, BALANCED_PROMOTIONAL_PACKAGE)),
        AGGRESSIVE("Aggressive",
                new RetentionStrategy(AGGRESSIVE_PROMOTIONAL_EMAIL, AGGRESSIVE_PROMOTIONAL_PACKAGE)),
        VERY_AGGRESSIVE("Very aggressive",
                new RetentionStrategy(VERY_AGGRESSIVE_PROMOTIONAL_EMAIL, VERY_AGGRESSIVE_PROMOTIONAL_PACKAGE));

        @Getter
        private String value;

        @Getter
        private RetentionStrategy retentionStrategy;

        Profile(String value, RetentionStrategy retentionStrategy) {
            this.value = value;
            this.retentionStrategy = retentionStrategy;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }

}
