package table;

public class inneholder {

}

CREATE TABLE inneholder
(OktID			INT			NOT NULL,
OvelsesID		INT			NOT NULL,
PRIMARY KEY (OktID, OvelsesID),
CONSTRAINT OktIDForeignKey
	FOREIGN KEY (OktID)
    REFERENCES treningsokt (OktID)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
CONSTRAINT OvelsesIDForeignKey
	FOREIGN KEY (OvelsesID)
	REFERENCES ovelse (OvelsesID)
    ON DELETE CASCADE
    ON UPDATE CASCADE);