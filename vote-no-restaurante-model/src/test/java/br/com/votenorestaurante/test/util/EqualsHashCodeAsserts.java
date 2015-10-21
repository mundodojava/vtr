package br.com.votenorestaurante.test.util;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.List;

import org.junit.Test;

import com.google.common.base.Predicate;

/**
 * Classe utilizada para testes de entidades do sistema
 * 
 */
public abstract class EqualsHashCodeAsserts {

    private final static int NUM_ITERATIONS = 20;

    private EqualsHashCodeAsserts() {

    }

    @Test
    public static final <T> void equalsHashCodeValid(List<T> equalsList, T notEquals) {

        assertNotNull("equalsList cannot be null", equalsList);
        assertNotNull("notEquals cannot be null", notEquals);
        assertThat("equalsList cannot be empty", equalsList, hasSize(greaterThan(0)));

        // verifica se == de Objetos é falso
        for (int i = 0; i < equalsList.size(); i++) {
            for (int j = i + 1; j < equalsList.size(); j++) {
                assertNotNull(position(i) + " object in equalsList cannot be null", equalsList);
                assertNotSame(equalsList.get(i), equalsList.get(j));
                assertNotSame(equalsList.get(i), notEquals);
            }
        }
        testHashCodeContract(equalsList, notEquals);
        testEqualsAgainstNewObject(equalsList, notEquals);
        testEqualsAgainstNull(equalsList, notEquals);
        testEqualsAgainstUnequalObjects(equalsList, notEquals);
        testEqualsIsReflexive(equalsList, notEquals);
        testEqualsIsSymmetricAndTransitive(equalsList, notEquals);
        testEqualsIsConsistentAcrossInvocations(equalsList, notEquals);
    }

    /***********************************************************************
     *********************** Testes equals e hashCode ***********************
     **********************************************************************/

    /**
     * Tests whether <code>equals</code> holds up against a new
     * <code>Object</code> (should always be <code>false</code>).
     * 
     * @param <T>
     */
    @Test
    private static final <T> void testEqualsAgainstNewObject(List<T> equalsList, T notEquals) {
        Object o = new Object();

        for (int i = 0; i < equalsList.size(); i++) {
            assertNotSame(position(i) + " vs. new Object", equalsList.get(i), o);
        }
        assertNotSame("not-equal vs. new Object", notEquals, o);
    }

    /**
     * Tests whether <code>equals</code> holds up against <code>null</code>.
     */
    @Test
    private static final <T> void testEqualsAgainstNull(List<T> equalsList, T notEquals) {
        for (int i = 0; i < equalsList.size(); i++) {
            assertNotSame(position(i) + " vs. null", equalsList.get(i), null);
        }
        assertNotSame("not-equal vs. null", notEquals, null);

    }

    /**
     * Tests whether <code>equals</code> holds up against objects that should
     * not compare equal.
     */
    @Test
    private static final <T> void testEqualsAgainstUnequalObjects(List<T> equalsList, T notEquals) {

        for (int i = 0; i < equalsList.size(); i++) {
            assertThat(position(i) + " vs. not-equal", equalsList.get(i), not(equalTo(notEquals)));
            assertThat("not-equal vs. " + position(i), notEquals, not(equalTo(equalsList.get(i))));
        }
    }

    /**
     * Tests whether <code>equals</code> is <em>consistent</em>.
     * 
     * @param <T>
     */
    @Test
    private static final <T> void testEqualsIsConsistentAcrossInvocations(List<T> equalsList, T notEquals) {
        for (int i = 0; i < NUM_ITERATIONS; ++i) {
            testEqualsAgainstNewObject(equalsList, notEquals);
            testEqualsAgainstNull(equalsList, notEquals);
            testEqualsAgainstUnequalObjects(equalsList, notEquals);
            testEqualsIsReflexive(equalsList, notEquals);
            testEqualsIsSymmetricAndTransitive(equalsList, notEquals);
        }
    }

    /**
     * Tests whether <code>equals</code> is <em>reflexive</em>.
     * 
     * @param <T>
     */
    @Test
    private static final <T> void testEqualsIsReflexive(List<T> equalsList, T notEquals) {
        for (int i = 0; i < equalsList.size(); i++) {
            assertThat(position(i) + " equal instance", equalsList.get(i), equalTo(equalsList.get(i)));
        }
        assertThat("not-equal equal instance", notEquals, equalTo(notEquals));
    }

    /**
     * Tests whether <code>equals</code> is <em>symmetric</em> and
     * <em>transitive</em>.
     * 
     * @param <T>
     */
    @Test
    private static final <T> void testEqualsIsSymmetricAndTransitive(List<T> equalsList, T notEquals) {

        // verifica se os itens iguais são iguais a todos os outros da lista
        for (T item : equalsList) {
            List<T> list2 = newArrayList(filter(equalsList, predicate(item)));
            for (T item2 : list2) {
                assertThat(item, equalTo(item2));
                assertThat(item2, equalTo(item));
            }

        }
    }

    /**
     * Tests the <code>hashCode</code> contract.
     * 
     * @param <T>
     */
    private static final <T> void testHashCodeContract(List<T> equalsList, T notEquals) {

        for (int i = 0; i < equalsList.size(); i++) {
            for (int j = i + 1; j < equalsList.size(); j++) {
                assertThat(position(i) + " vs. " + position(j), equalsList.get(i).hashCode(), equalTo(equalsList.get(j).hashCode()));
            }
        }
    }

    /**
     * Tests the consistency of <code>hashCode</code>.
     * 
     * @param <T>
     */
    @Test
    private final <T> void testHashCodeIsConsistentAcrossInvocations(List<T> equalsList, T notEquals) {

        int hashcode;
        int neqHash = notEquals.hashCode();

        for (T item : equalsList) {
            hashcode = item.hashCode();

            for (int i = 0; i < NUM_ITERATIONS; ++i) {
                assertThat(hashcode, equalTo(item.hashCode()));
                assertThat(neqHash, equalTo(notEquals.hashCode()));
            }
        }

    }

    private static final String position(int position) {
        String retorno = "";
        switch (position) {
        case 0:
            retorno = "1st";
            break;
        case 1:
            retorno = "2nd";
            break;
        case 2:
            retorno = "3rd";
            break;
        }
        return retorno;

    }

    private static Predicate<Object> predicate(Object exclude) {
        return new TestPredicate(exclude);
    }

    private static class TestPredicate implements Predicate<Object> {

        private final Object exclude;

        public TestPredicate(Object exclude) {
            this.exclude = exclude;
        }

        @Override
        public boolean apply(Object input) {
            return input != exclude;
        }

    }

}
