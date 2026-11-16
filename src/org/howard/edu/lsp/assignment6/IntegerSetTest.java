package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import java.util.function.BinaryOperator;
import org.junit.jupiter.api.Test;

/**
 * Assignment 6: JUnit 5 tests for IntegerSet.
 *
 * Each test must contain meaningful assertions and run independently.
 */
public class IntegerSetTest {

    // ===== clear() =====

    /**
     * Create a populated set; call clear(); assert that it is empty and its length is zero.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testClearClearsPopulatedSet() {
        IntegerSet a = set(9, -2);
        a.clear();
        assertTrue(a.isEmpty());
        assertEquals(0, a.length());
    }

    /**
     * Clear an already empty set; verify it remains empty.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testClearClearsEmptySet() {
        IntegerSet a = new IntegerSet();
        a.clear();
        assertTrue(a.isEmpty());
        assertEquals(0, a.length());
    }

    // ===== length() =====

    /**
     * Add repeated and unique integers; assert the number of distinct elements.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLengthCountsUniqueElements() {
        IntegerSet a = set(3, 3, -4, 3, 7, -4);
        assertEquals(3, a.length());
    }

    /**
     * Verify a new empty set has length zero.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLengthEmptySetLength() {
        assertEquals(0, new IntegerSet().length());
    }

    // ===== equals() =====

    /**
     * Construct sets with identical elements in different insertion orders; assert equality.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testEqualsIgnoresInsertionOrder() {
        IntegerSet a = set(3, -4, 1);
        IntegerSet b = set(1, 3, -4);
        assertTrue(a.equals(b));
        assertTrue(b.equals(a));
    }

    /**
     * Construct sets of equal length with different elements; assert inequality.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testEqualsDetectsDifferentContents() {
        IntegerSet a = set(3, -4);
        IntegerSet b = set(3, 1);
        assertFalse(a.equals(b));
        assertFalse(b.equals(a));
    }

    /**
     * Verify two separately constructed empty sets compare equal.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testEqualsEmptySetsEqual() {
        assertTrue(new IntegerSet().equals(new IntegerSet()));
    }

    /**
     * Verify a set equals itself and differs from a set of another size.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testEqualsSameObjectAndDifferentSizes() {
        IntegerSet a = set(1, 2);
        IntegerSet b = set(1, 2, 3);
        assertTrue(a.equals(a));
        assertFalse(a.equals(b));
        assertFalse(b.equals(a));
    }

    // ===== contains() =====

    /**
     * Verify contains() is true for a present element and false for an absent one.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testContainsPresentAndAbsent() {
        IntegerSet a = set(-3, 4);
        assertTrue(a.contains(-3));
        assertFalse(a.contains(5));
    }

    /**
     * Verify an empty set does not contain an arbitrary integer.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testContainsEmptySetContainsNothing() {
        assertFalse(new IntegerSet().contains(17));
    }

    // ===== largest() =====

    /**
     * Verify largest() returns the maximum across negative, zero, and positive values.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLargestNegativeAndPositiveValues() {
        assertEquals(9, set(0, 9, -7, 3).largest());
        assertEquals(-2, set(-5, -2, -9).largest());
    }

    /**
     * Use assertThrows() to verify IllegalStateException for an empty set.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testLargestEmptySetThrowsException() {
        IntegerSet a = new IntegerSet();
        assertThrows(IllegalStateException.class, a::largest);
    }

    // ===== smallest() =====

    /**
     * Verify smallest() returns the minimum across negative, zero, and positive values.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSmallestNegativeAndPositiveValues() {
        assertEquals(-7, set(0, -7, 9, 3).smallest());
        assertEquals(2, set(5, 2, 9).smallest());
    }

    /**
     * Use assertThrows() to verify IllegalStateException for an empty set.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSmallestEmptySetThrowsException() {
        IntegerSet a = new IntegerSet();
        assertThrows(IllegalStateException.class, a::smallest);
    }

    // ===== add() =====

    /**
     * Add the same integer repeatedly; verify only one copy exists.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testAddIgnoresDuplicates() {
        IntegerSet a = set(8);
        a.add(8);
        a.add(8);
        assertContents(a, 8);
    }

    /**
     * Add Integer.MIN_VALUE, Integer.MAX_VALUE, and zero; verify all are represented.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testAddHandlesIntegerBoundaries() {
        IntegerSet a = new IntegerSet();
        a.add(Integer.MIN_VALUE);
        a.add(Integer.MAX_VALUE);
        a.add(0);
        assertContents(a, Integer.MIN_VALUE, 0, Integer.MAX_VALUE);
    }

    // ===== remove() =====

    /**
     * Remove a present element; verify it is absent and others remain.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testRemoveRemovesExistingElement() {
        IntegerSet a = set(-5, 0, 8);
        a.remove(0);
        assertFalse(a.contains(0));
        assertContents(a, -5, 8);
    }

    /**
     * Remove an absent element; verify the set is unchanged.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testRemoveIgnoresAbsentElement() {
        IntegerSet a = set(1, 4);
        a.remove(0);
        assertContents(a, 1, 4);
    }

    // ===== union() =====

    /**
     * Verify union() contains all distinct elements from two overlapping sets.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testUnionOverlappingSets() {
        checkOperation(IntegerSet::union, set(1, 3), set(3, 8), 1, 3, 8);
    }

    /**
     * Verify union with an empty set and with the same object.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testUnionEmptyAndSameOperand() {
        IntegerSet a = set(1, 3);
        IntegerSet empty = set();
        checkOperation(IntegerSet::union, a, empty, 1, 3);
        checkOperation(IntegerSet::union, empty, a, 1, 3);
        checkOperation(IntegerSet::union, a, a, 1, 3);
    }

    /**
     * Verify both inputs remain unchanged; modify the result and verify the inputs are still unchanged.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testUnionDoesNotMutateInputs() {
        checkIndependent(IntegerSet::union, set(1, 3), set(3, 8), 1, 3, 8);
    }

    // ===== intersect() =====

    /**
     * Verify intersection contains exactly the shared elements.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIntersectOverlappingSets() {
        checkOperation(IntegerSet::intersect, set(1, 3, 5), set(3, 5, 8), 3, 5);
    }

    /**
     * Verify disjoint intersection is empty and self-intersection is unchanged.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIntersectDisjointAndSameOperand() {
        IntegerSet a = set(1, 3);
        checkOperation(IntegerSet::intersect, a, set(4, 8));
        checkOperation(IntegerSet::intersect, a, a, 1, 3);
    }

    /**
     * Modify the intersection result and verify both input sets remain unchanged.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testIntersectIndependentResult() {
        checkIndependent(IntegerSet::intersect, set(1, 3), set(3, 8), 3);
    }

    // ===== diff() =====

    /**
     * Verify A.diff(B) returns elements in A but not B, and distinguish direction.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testDiffDirectionMatters() {
        IntegerSet a = set(1, 3);
        IntegerSet b = set(3, 8);
        checkOperation(IntegerSet::diff, a, b, 1);
        checkOperation(IntegerSet::diff, b, a, 8);
    }

    /**
     * Verify difference with an empty set and difference with itself.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testDiffEmptyAndSameOperand() {
        IntegerSet a = set(1, 3);
        IntegerSet empty = set();
        checkOperation(IntegerSet::diff, a, empty, 1, 3);
        checkOperation(IntegerSet::diff, empty, a);
        checkOperation(IntegerSet::diff, a, a);
    }

    /**
     * Modify the difference result and verify neither input changes.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testDiffIndependentResult() {
        checkIndependent(IntegerSet::diff, set(1, 3), set(3, 8), 1);
    }

    // ===== complement() =====

    /**
     * Verify A.complement(B) returns elements in B but not A.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testComplementReverseDifference() {
        IntegerSet a = set(1, 3);
        IntegerSet b = set(3, 8);
        checkOperation(IntegerSet::complement, a, b, 8);
        checkOperation(IntegerSet::complement, b, a, 1);
    }

    /**
     * Verify complement with an empty receiver and with an empty argument.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testComplementEmptyOperands() {
        IntegerSet a = set(1, 3);
        IntegerSet empty = set();
        checkOperation(IntegerSet::complement, a, empty);
        checkOperation(IntegerSet::complement, empty, a, 1, 3);
    }

    /**
     * Modify the complement result and verify neither input changes.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testComplementIndependentResult() {
        checkIndependent(IntegerSet::complement, set(1, 3), set(3, 8), 8);
    }

    // ===== isSubsetOf() =====

    /**
     * Verify a proper subset is recognized.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsSubsetOfProperSubset() {
        assertTrue(set(3, 8).isSubsetOf(set(1, 3, 8)));
    }

    /**
     * Verify a set with an element missing from the other set is not a subset.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsSubsetOfNotSubset() {
        assertFalse(set(3, 9).isSubsetOf(set(1, 3, 8)));
    }

    /**
     * Verify equal sets are subsets of each other.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsSubsetOfEqualSets() {
        IntegerSet a = set(3, 8);
        IntegerSet b = set(8, 3);
        assertTrue(a.isSubsetOf(b));
        assertTrue(b.isSubsetOf(a));
    }

    /**
     * Verify the empty set is a subset of a nonempty set, but not vice versa.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsSubsetOfEmptyCases() {
        IntegerSet empty = set();
        IntegerSet a = set(4);
        assertTrue(empty.isSubsetOf(a));
        assertFalse(a.isSubsetOf(empty));
        assertTrue(empty.isSubsetOf(set()));
    }

    // ===== isDisjoint() =====

    /**
     * Verify disjoint sets return true.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsDisjointNoOverlap() {
        assertTrue(set(1, 3).isDisjoint(set(4, 8)));
    }

    /**
     * Verify overlapping sets return false.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsDisjointOverlap() {
        assertFalse(set(1, 3).isDisjoint(set(3, 8)));
    }

    /**
     * Verify disjointness with an empty set and with the same nonempty object.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testIsDisjointEmptyAndSameOperand() {
        IntegerSet a = set(1, 3);
        IntegerSet empty = set();
        assertTrue(a.isDisjoint(empty));
        assertTrue(empty.isDisjoint(a));
        assertFalse(a.isDisjoint(a));
    }

    // ===== symmetricDiff() =====

    /**
     * Verify symmetric difference contains elements appearing in exactly one set.
     * Assignment 5 equivalent: 3 point(s).
     */
    @Test
    public void testSymmetricDiffPartiallyOverlappingSets() {
        checkOperation(IntegerSet::symmetricDiff, set(1, 3, 5), set(3, 5, 8), 1, 8);
    }

    /**
     * Verify symmetric difference of identical sets is empty.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSymmetricDiffIdenticalSets() {
        checkOperation(IntegerSet::symmetricDiff, set(1, 3), set(3, 1));
    }

    /**
     * Verify behavior with an empty set and with disjoint sets.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSymmetricDiffEmptyAndDisjointSets() {
        IntegerSet a = set(1, 3);
        IntegerSet empty = set();
        checkOperation(IntegerSet::symmetricDiff, a, empty, 1, 3);
        checkOperation(IntegerSet::symmetricDiff, empty, a, 1, 3);
        checkOperation(IntegerSet::symmetricDiff, a, set(4, 8), 1, 3, 4, 8);
    }

    /**
     * Modify the result and verify both input sets remain unchanged.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testSymmetricDiffIndependentResult() {
        checkIndependent(IntegerSet::symmetricDiff, set(1, 3), set(3, 8), 1, 8);
    }

    // ===== isEmpty() =====

    /**
     * Verify a newly constructed set is empty.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsEmptyNewSet() {
        assertTrue(new IntegerSet().isEmpty());
    }

    /**
     * Verify a set with an element is not empty.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsEmptyPopulatedSet() {
        assertFalse(set(0).isEmpty());
    }

    /**
     * Clear a populated set and verify it is empty.
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testIsEmptyAfterClear() {
        IntegerSet a = set(4, 7);
        a.clear();
        assertTrue(a.isEmpty());
    }

    // ===== toString() =====

    /**
     * Verify elements appear in ascending numeric order regardless of insertion order.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testToStringAscendingOrder() {
        assertEquals("[-4, 0, 2, 10]", set(10, 2, -4, 0).toString());
    }

    /**
     * Verify an empty set formats as [].
     * Assignment 5 equivalent: 1 point(s).
     */
    @Test
    public void testToStringEmptyFormatting() {
        assertEquals("[]", new IntegerSet().toString());
    }

    /**
     * Verify comma-space formatting, brackets, and duplicate suppression.
     * Assignment 5 equivalent: 2 point(s).
     */
    @Test
    public void testToStringExactSpacingAndDuplicates() {
        assertEquals("[-1, 0, 7]", set(7, 7, -1, 0, -1).toString());
    }

    private static IntegerSet set(int... values) {
        IntegerSet result = new IntegerSet();
        for (int value : values) {
            result.add(value);
        }
        return result;
    }

    private static void assertContents(IntegerSet actual, int... expected) {
        assertEquals(expected.length, actual.length(), "Set size");
        for (int value : expected) {
            assertTrue(actual.contains(value), "Missing element: " + value);
        }
    }

    private static IntegerSet checkOperation(BinaryOperator<IntegerSet> operation,
            IntegerSet left, IntegerSet right, int... expected) {
        String leftBefore = left.toString();
        String rightBefore = right.toString();

        IntegerSet result = operation.apply(left, right);

        assertContents(result, expected);
        assertEquals(leftBefore, left.toString(), "Left operand changed");
        assertEquals(rightBefore, right.toString(), "Right operand changed");
        return result;
    }

    private static void checkIndependent(BinaryOperator<IntegerSet> operation,
            IntegerSet left, IntegerSet right, int... expected) {
        String leftBefore = left.toString();
        String rightBefore = right.toString();
        IntegerSet result = checkOperation(operation, left, right, expected);
        assertNotSame(left, result);
        assertNotSame(right, result);

        result.remove(expected[0]);
        int newValue = 99; // Absent from both inputs in all independence tests.
        result.add(newValue);

        assertFalse(result.contains(expected[0]), "Removed element is still in the result");
        assertTrue(result.contains(newValue), "Added element is missing from the result");
        assertEquals(expected.length, result.length(), "Result size after remove and add");
        assertEquals(leftBefore, left.toString(), "Result shares storage with left operand");
        assertEquals(rightBefore, right.toString(), "Result shares storage with right operand");
    }
}
