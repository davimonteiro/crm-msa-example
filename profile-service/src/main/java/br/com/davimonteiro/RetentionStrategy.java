package br.com.davimonteiro;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RetentionStrategy {

    private EmailType emailType;

    private PackageType packageType;

    private Long consumerId;

    public RetentionStrategy(EmailType emailType, PackageType packageType) {
        this.emailType = emailType;
        this.packageType = packageType;
    }

    public enum EmailType {
        WELCOME_EMAIL("welcome_email"),
        CONSERVATIVE_PROMOTIONAL_EMAIL("conservative_promotional_email"),
        MODERATELY_CONSERVATIVE_PROMOTIONAL_EMAIL("moderately_conservative_promotional_email"),
        BALANCED_PROMOTIONAL_EMAIL("balanced_promotional_email"),
        AGGRESSIVE_PROMOTIONAL_EMAIL("aggressive_promotional_email"),
        VERY_AGGRESSIVE_PROMOTIONAL_EMAIL("very_aggressive_promotional_email");

        @Getter
        @JsonValue
        private final String type;

        EmailType(String type) {
            this.type = type;
        }
    }

    public enum PackageType {
        WELCOME_PACKAGE("welcome_package"),
        CONSERVATIVE_PROMOTIONAL_PACKAGE("conservative_promotional_package"),
        MODERATELY_CONSERVATIVE_PROMOTIONAL_PACKAGE("moderately_conservative_promotional_package"),
        BALANCED_PROMOTIONAL_PACKAGE("balanced_promotional_package"),
        AGGRESSIVE_PROMOTIONAL_PACKAGE("aggressive_promotional_package"),
        VERY_AGGRESSIVE_PROMOTIONAL_PACKAGE("very_aggressive_promotional_package");

        @Getter
        @JsonValue
        private final String type;

        PackageType(String type) {
            this.type = type;
        }
    }

}
