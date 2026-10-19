package org.howard.edu.lsp.assignment5;

import java.util.Collections;
import java.util.Objects;
import java.util.TreeSet;

/**
 * A mutable mathematical set of integers with no duplicate elements.
 * Set-producing operations return independent sets and leave both operands
 * unchanged. Elements are displayed in ascending numerical order.
 * Except for equality, methods accepting a set reject null operands.
 */
public class IntegerSet {
    private final TreeSet<Integer> elements = new TreeSet<>();

    /** Creates an empty set. */
    public IntegerSet() {
    }

    /** Removes all elements from this set. */
    public void clear() {
        elements.clear();
    }

    /**
     * Returns the number of distinct elements.
     * @return the set's size
     */
    public int length() {
        return elements.size();
    }

    /**
     * Compares sets without regard to insertion order.
     * @param b the set to compare, possibly null
     * @return true if b is non-null and has exactly the same elements
     */
    public boolean equals(IntegerSet b) {
        return b != null && elements.equals(b.elements);
    }

    /**
     * Compares this set with an object by its integer elements.
     * @param other the object to compare
     * @return true if other is an IntegerSet with the same elements
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof IntegerSet && equals((IntegerSet) other);
    }

    /**
     * Returns a hash consistent with element-based equality.
     * @return the hash of the elements
     */
    @Override
    public int hashCode() {
        return elements.hashCode();
    }

    /**
     * Tests whether a value belongs to this set.
     * @param value the integer to find
     * @return true if value is present
     */
    public boolean contains(int value) {
        return elements.contains(value);
    }

    /**
     * Returns the greatest element.
     * @return the largest integer
     * @throws IllegalStateException if this set is empty
     */
    public int largest() {
        if (isEmpty()) {
            throw new IllegalStateException("An empty set has no largest element.");
        }
        return elements.last();
    }

    /**
     * Returns the least element.
     * @return the smallest integer
     * @throws IllegalStateException if this set is empty
     */
    public int smallest() {
        if (isEmpty()) {
            throw new IllegalStateException("An empty set has no smallest element.");
        }
        return elements.first();
    }

    /**
     * Adds an integer, ignoring duplicates.
     * @param item the integer to add
     */
    public void add(int item) {
        elements.add(item);
    }

    /**
     * Removes an integer if present; otherwise leaves this set unchanged.
     * @param item the integer to remove
     */
    public void remove(int item) {
        elements.remove(item);
    }

    /**
     * Returns the elements present in either operand.
     * @param b the other set
     * @return a new independent union
     * @throws NullPointerException if b is null
     */
    public IntegerSet union(IntegerSet b) {
        Objects.requireNonNull(b, "b");
        IntegerSet result = copy();
        result.elements.addAll(b.elements);
        return result;
    }

    /**
     * Returns the elements shared by both operands.
     * @param b the other set
     * @return a new independent intersection
     * @throws NullPointerException if b is null
     */
    public IntegerSet intersect(IntegerSet b) {
        Objects.requireNonNull(b, "b");
        IntegerSet result = copy();
        result.elements.retainAll(b.elements);
        return result;
    }

    /**
     * Returns the elements of this set that are absent from b.
     * @param b the set whose elements are excluded
     * @return a new independent difference, this minus b
     * @throws NullPointerException if b is null
     */
    public IntegerSet diff(IntegerSet b) {
        Objects.requireNonNull(b, "b");
        IntegerSet result = copy();
        result.elements.removeAll(b.elements);
        return result;
    }

    /**
     * Returns elements in b but not in this set, as defined by this assignment.
     * @param b the set from which this set's elements are excluded
     * @return a new independent difference, b minus this
     * @throws NullPointerException if b is null
     */
    public IntegerSet complement(IntegerSet b) {
        Objects.requireNonNull(b, "b");
        return b.diff(this);
    }

    /**
     * Tests whether every element of this set is in b.
     * An empty set is a subset of every non-null set.
     * @param b the possible containing set
     * @return true if this set is a subset of b
     * @throws NullPointerException if b is null
     */
    public boolean isSubsetOf(IntegerSet b) {
        Objects.requireNonNull(b, "b");
        return b.elements.containsAll(elements);
    }

    /**
     * Tests whether the operands have no common elements.
     * An empty set is disjoint from every non-null set.
     * @param b the other set
     * @return true if no elements are shared
     * @throws NullPointerException if b is null
     */
    public boolean isDisjoint(IntegerSet b) {
        Objects.requireNonNull(b, "b");
        return Collections.disjoint(elements, b.elements);
    }

    /**
     * Returns elements that belong to exactly one operand.
     * @param b the other set
     * @return a new independent symmetric difference
     * @throws NullPointerException if b is null
     */
    public IntegerSet symmetricDiff(IntegerSet b) {
        Objects.requireNonNull(b, "b");
        IntegerSet result = union(b);
        result.elements.removeAll(intersect(b).elements);
        return result;
    }

    /**
     * Tests whether this set has no elements.
     * @return true if empty
     */
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /**
     * Formats the elements in ascending order, separated by comma and space.
     * @return bracketed elements, or {@code []} for an empty set
     */
    @Override
    public String toString() {
        return elements.toString();
    }

    private IntegerSet copy() {
        IntegerSet result = new IntegerSet();
        result.elements.addAll(elements);
        return result;
    }
}
