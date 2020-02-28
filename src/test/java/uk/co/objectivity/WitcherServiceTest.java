package uk.co.objectivity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WitcherServiceTest {

    private static final int POUCH_CAPACITY = 10;
    private WitcherService witcherService;

    @BeforeEach
    void setUp() {
        witcherService = new WitcherService(POUCH_CAPACITY);
    }

    @Test
    void shouldThrowExceptionWhenCoinValueDoesNotSatisfyWitcher() {
        assertThatThrownBy(() -> witcherService.toss(new Coin(5, 5)))
                .isInstanceOf(WitcherDissatisfiedException.class)
                .hasMessage("zaraza");
    }

    @Test
    void shouldReturnFalseWhenThereIsNoMoreSpaceForCoin() {
        boolean result = witcherService.toss(new Coin(15, 15));

        assertThat(result).isFalse();
    }

    @Test
    void shouldReturnTrueWhenCoinSatisfiesWitcherAndFitsIntoPouch() {
        boolean result = witcherService.toss(new Coin(15, 5));

        assertThat(result).isTrue();
    }

    @Test
    void shouldReturnTrueWhenCoinSatisfiesWitcherWithMinAcceptableValueAndFitsIntoPouch() {
        boolean result = witcherService.toss(new Coin(10, 5));

        assertThat(result).isTrue();
    }

    @Test
    void shouldReturnTrueWhenCoinSatisfiesWitcherAndFitsPouchWithMaxAcceptableSize() {
        boolean result = witcherService.toss(new Coin(15, 10));

        assertThat(result).isTrue();
    }

    @Test
    void shouldReturnFalseWhenThereIsNoMoreSpaceForSecondCoin() {
        witcherService.toss(new Coin(15, 10));

        boolean result = witcherService.toss(new Coin(15, 1));

        assertThat(result).isFalse();
    }
}