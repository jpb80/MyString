/**Jordan Buttkevitz
 * University of Pittsburgh
 * Data Structures
 * Project: MyString
 * */

package javaapplication1;

/**
 * NOTE: The purpose of this interface is to enforce you to develop
 * methods defined in this interface. Creating MyString class by
 * implementing this interface will allow you to keep track of what
 * methods that you must implement. All comments in this interface
 * were written as if this is a class named MyString. So, when you
 * use MyString, you can simply create a reference of type MyString
 * as follows:
 * 
 * Mystring ms = new MyString(...);
 * 
 * For simplicity, you do not have to use interface type.
 */
public interface MyStringInterface
{
	/**
	 * Append MyString ms to the end of this sequence and return
	 * the reference to this object. Note that both ms and this sequence
	 * can be empty.
	 * 
	 * @param ms  A MyString object to be appended to the end of this
	 *             sequence
	 * @return a reference to this object
	 */
	public MyString append(MyString ms);

	/**
	 * Append String s to the end of this sequence and return the
	 * reference to this object. Note that both s and this sequence can
	 * be empty.
	 * 
	 * @param s  A String object to be appended to the end of this sequence
	 * @return a reference to this object
	 */
	public MyString append(String s);

	/**
	 * Append the array of character c to the end of this sequence and
	 * return the reference to this object. Note that the length of c can
	 * be 0 and this sequence can be empty.
	 * 
	 * @param c  An array of character to be appended to the end of this
	 *           sequence
	 * @return a reference to this object
	 */
	public MyString append(char [] c);

	/** 
	 * Return the character at location "index" of this sequence. If index
	 * is invalid, return the null character. 
	 * 
	 * @param index  the index of the desired char value
	 * @return the char value at the specified index. Null if index is
	 *         invalid.
	 */
	public char charAt(int index);

	/**
	 * Delete the character from index start to index end - 1 from the
	 * current sequence and return the reference to this sequence. If the
	 * start index is invalid or end <= start, do nothing. If end is past
	 * the end of the sequence, simply delete until the end of the sequence.
	 * 
	 * @param start  The beginning index, inclusive
	 * @param end  The ending index, exclusive
	 * @return a reference to this object
	 */
	public MyString delete(int start, int end);

	/**
	 * Removes the char at the specified position in this sequence and
	 * return the reference to this object. If index is invalid, do
	 * nothing.
	 * 
	 * @param index  Index of char to remove
	 * @return a reference to this object
	 */
	public MyString deleteCharAt(int index);

	/**
	 * Returns the index within this string of the first occurrence of
	 * the specified substring. If str does not match any sequence of
	 * characters within the current sequence, return -1.
	 * 
	 * @param str  any string
	 * @return if the string argument occurs as a substring within this
	 *          sequence, then the index of the first character of the
	 *          first such substring is returned. If it does not occur
	 *          as a substring, -1 is returned.
	 */
	public int indexOf(String str);

	/**
	 * Inserts the string str into this sequence starting at the index
	 * and return the reference to this sequence. If the index is
	 * invalid, do nothing.
	 * 
	 * @param offset  The offset
	 * @param str  A string
	 * @return a reference to this object
	 */
	public MyString insert(int index, String str);

	/**
	 * Inserts the character c into this sequence at the index and
	 * return the reference to this sequence. If the index is invalid,
	 * do nothing.
	 * 
     * @param index
	 * @param offset  The offset
	 * @param c  A character
	 * @return a reference to this object
	 */
	public MyString insert(int index, char c);

	/**
	 * Inserts the string representation of the char array argument into
	 * this sequence at the index and return the reference to this sequence.
	 * If the index is invalid, do nothing.
	 * 
     * @param index
	 * @param offset  The offset
	 * @param c  A character array
	 * @return a reference to this object
	 */
	public MyString insert(int index, char [] c);

	/**
	 * Return the length of this sequence
	 * 
	 * @return length of this sequence
	 */
	public int length();

	/**
	 * Replaces the characters in a substring of this sequence with
	 * characters in the specified String. the substring begins at the
	 * specified start and extends to the character at index end - 1 or to
	 * the end of the sequence. If start is invalid or end <= start, do
	 * nothing. If end is past the end of the sequence, only delete until
	 * the end of the sequence, then insert.
	 * 
	 * @param start  The beginning index, inclusive
	 * @param end  the ending index, exclusive
	 * @param str  String that will replace previous contents
	 * @return a reference to this object
	 */
	public MyString replace(int start, int end, String str);

	/**
	 * Returns a new String that contains a subsequence of characters
	 * currently contained in this character sequence. The substring begins
	 * at the specified index to the specified end - 1. If either start or
	 * end is invalid, return an empty string.
	 * 
	 * @param start  The beginning index, inclusive
	 * @param end  The ending index, exclusive
	 * @return the new string if both start and end are valid. Otherwise
	 *          return an empty string.
	 */
	public String subString(int start, int end);

	/**
	 * Replace this character sequence by the reverse of the sequence and
	 * return the reference to this object.
	 * 
	 * @return a reference to this object.
	 */
	public MyString reverse();
	
	/**
	 * Return the entire sequence of this sequence as a String
	 * 
	 * @return a string representation of this sequence of characters
	 */
        @SuppressWarnings("override")
	public String toString();
}
