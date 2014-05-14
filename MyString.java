/** Jordan Buttkevitz
 *  University of Pittsburgh
 *  Data Structures
 *  Project: MyString
 * */
package javaapplication1;

public class MyString implements MyStringInterface {
    private CNode firstNode;
    private int length;
  
    public MyString(String s) {
        CNode currentNode = null;
        if (s == null) { 
          length = 0;
        } else {
          length = s.length();
          for (int i = 0; i < s.length(); i++) {
              CNode newNode = new CNode(s.charAt(i));
              if ( i == 0 ) {
                  firstNode = newNode;
                  currentNode = newNode;
              } else {
                  currentNode.next = newNode;
                  currentNode = newNode;
              }         
          }
       }          
    }  

    public MyString(char[] c) {
        this(new String(c));
    }

    public MyString() { }

	/**
	 * Append MyString ms to the end of this sequence and return
	 * the reference to this object. Note that both ms and this sequence
	 * can be empty.
	 * 
	 * @param ms  A MyString object to be appended to the end of this
	 *             sequence
	 * @return a reference to this object
	 */
    @Override
    public MyString append(MyString ms) {
        ms = new MyString(ms.toString());
        if (ms.isEmpty()) {           
            return this;
        }
        
        CNode lastNode = getNodeAt(length - 1);
        CNode msFirstNode = ms.getNodeAt(0);
        if (lastNode == null) {
            firstNode = ms.firstNode;
            
        } else if (msFirstNode != null) {
            lastNode.next = msFirstNode;
        }
        length += ms.length();
        
        return this;
    }
            
	/**
	 * Append String s to the end of this sequence and return the
	 * reference to this object. Note that both s and this sequence can
	 * be empty.
	 * 
	 * @param s  A String object to be appended to the end of this sequence
	 * @return a reference to this object
	 */
        
    @Override
    public MyString append(String s) {
        return append(new MyString(s)); 
    }

	/**
	 * Append the array of character c to the end of this sequence and
	 * return the reference to this object. Note that the length of c can
	 * be 0 and this sequence can be empty.
	 * 
	 * @param c  An array of character to be appended to the end of this
	 *           sequence
	 * @return a reference to this object
	 */
    @Override
	public MyString append(char [] c) {
            return append(new MyString(c));
        }

	/** 
	 * Return the character at location "index" of this sequence. If index
	 * is invalid, return the null character. 
	 * 
	 * @param index  the index of the desired char value
	 * @return the char value at the specified index. Null if index is
	 *         invalid.
	 */
    @Override
	public char charAt(int index) {
            if (getNodeAt(index) == null) {
                return ' ';
            }
            return getNodeAt(index).data;    
        }
	       
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
    @Override
	public MyString delete(int start, int end) {
            if (start >= end) {
                return this;
            }
            if ( start < 0 || start >= length ||
                 end < 0) {
               return this;
            }
            CNode lastNodeToBeRemoved = getNodeAt(end - 1);
            if (start == 0) {
                if (lastNodeToBeRemoved == null) {
                    firstNode = null;
                    length = 0;
                    return null;
                }
                firstNode = lastNodeToBeRemoved.next; 
                
            } else {
                CNode beforeNode = getNodeAt(start - 1);  
                if (lastNodeToBeRemoved == null) {
                    beforeNode.next = null;
                    end = length - 1;
                } else {
                    beforeNode.next = lastNodeToBeRemoved.next;
                }
            }
            
            length -= end - start;
            
            // end would be inclusive in this case.
            if (lastNodeToBeRemoved == null) {
                length --;
            }
            
            return this;
        }

	/**
	 * Removes the char at the specified position in this sequence and
	 * return the reference to this object. If index is invalid, do
	 * nothing.
	 * 
	 * @param index  Index of char to remove
	 * @return a reference to this object
	 */
    @Override
	public MyString deleteCharAt(int index) {
           if ( index < 0 || index >= length || firstNode == null) {
                return this;
           }          
           if ( index == 0 ) {
                firstNode = firstNode.next;
                length --;
                return this;
           }            
            CNode beforeNode = getNodeAt(index - 1); 
            CNode toBeRemovedNode = beforeNode.next;    
            beforeNode.next = toBeRemovedNode.next;
            toBeRemovedNode.next = null; 
            length --;
            return this;  
        }

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
    @Override
	public int indexOf(String str) {
            if (str == null || str.length() == 0) {
                return -1;
            }
            
            int i = 0, j = 0;
            int firstMatchedIndex = -1;
             
            while (i < length && j < str.length()) {
                if (getNodeAt(i).data != str.charAt(j)) {
                    if(firstMatchedIndex == -1) {
                       i++;
                    } else {
                       i = firstMatchedIndex + 1;
                    }
                    j = 0;
                    firstMatchedIndex = -1;
            } else {
                    firstMatchedIndex = i; 
                    while (j < str.length() &&
                           i < length &&
                           getNodeAt(i).data == str.charAt(j)) {
                        
                        i++;
                        j++;
                    } 
                    if (j == str.length()) {
                        return firstMatchedIndex;
                    }
                }
            }
            
            return firstMatchedIndex;
        }

	/**
	 * Inserts the string str into this sequence starting at the index
	 * and return the reference to this sequence. If the index is
	 * invalid, do nothing.
	 * 
	 * @param offset  The offset
	 * @param str  A string
	 * @return a reference to this object
	 */
    @Override
	public MyString insert(int index, String str) { 
            if (index < 0 || index > length() || str.length() == 0) { 
                return this;
            }
            MyString insertStr = new MyString(str);
            CNode firstInsertNode = insertStr.getNodeAt(0);
            CNode temp = insertStr.getNodeAt(insertStr.length() - 1);
            CNode beforeCN = getNodeAt(index - 1);
            if (index == 0) {
                CNode currentNode = getNodeAt(0);
                temp.next = currentNode;
                firstNode = firstInsertNode;
                length += str.length();
            } else {
                CNode currentNode = getNodeAt(index);
                //if ((index - 1) == 0) {
                  //  firstNode.next = firstInsertNode;
                //}
                temp.next = currentNode;
                beforeCN.next = firstInsertNode;
                length += str.length();
            }                
           return this; 
        }

	/**
	 * Inserts the character c into this sequence at the index and
	 * return the reference to this sequence. If the index is invalid,
	 * do nothing.
	 * 
	 * @param offset  The offset
	 * @param c  A character
	 * @return a reference to this object
	 */
    @Override
	public MyString insert(int index, char c) {
            CNode toBeInsertedNode = new CNode(c);
            CNode beforeInsertNode;
            CNode offSetNode;
            if (isEmpty() || index > this.length()) { }   
            if (index == 0) {
                offSetNode = getNodeAt(index);
                toBeInsertedNode.next = offSetNode;
                firstNode = offSetNode;   
                length++;  
            } else {
            offSetNode = getNodeAt(index);
            beforeInsertNode = getNodeAt(index - 1);
            beforeInsertNode.next = toBeInsertedNode;
            toBeInsertedNode.next = offSetNode;
            length++; 
            }
            return this;
        }

	/**
	 * Inserts the string representation of the char array argument into
	 * this sequence at the index and return the reference to this sequence.
	 * If the index is invalid, do nothing.
	 * 
	 * @param offset  The offset
	 * @param c  A character array
	 * @return a reference to this object
	 */
    @Override
	public MyString insert(int index, char [] c) {
            if (index < 0 || index > length()) {
                return this;
            }
            MyString insertStr = new MyString(c);
            CNode currentNode = null;
            CNode firstInsertNode = insertStr.getNodeAt(0);
            CNode temp = insertStr.getNodeAt(insertStr.length() - 1);
            if (index == 0) {
                currentNode = getNodeAt(0);
                temp.next = currentNode;
                firstNode = firstInsertNode;
                length += insertStr.length();
            } else {
                currentNode = getNodeAt(index - 1);
                temp.next = currentNode.next;
                currentNode.next = firstInsertNode;
                length += insertStr.length();
            }                
           return this; 
        }
	/**
	 * Return the length of this sequence
	 * 
	 * @return length of this sequence
	 */
    @Override
	public int length() {
            return length;
        } 
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
    @Override
	public MyString replace(int start, int end, String str) {
            if(start < 0 || end > length() || start == end || start > end) {
                return this;
            }
            insert(end, str);
            delete(start,end);
            return this;    
        } 
        
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
    @Override
	public String subString(int start, int end) {
            String str = "";
            if (start < 0 || end > this.length()) { 
                return "";
            }
            for (int i = start; i < end; i++) {
                str = str + "" + getNodeAt(i).data;
            }
            return str;
        }

	/**
	 * Replace this character sequence by the reverse of the sequence and
	 * return the reference to this object.
	 * 
	 * @return a reference to this object.
	 */
    @Override
	public MyString reverse() {      
            CNode currentNode = firstNode;
            firstNode = null;
            while (currentNode!=null){
                CNode tempNode = currentNode;
                currentNode = currentNode.next;
                tempNode.next = firstNode;
                firstNode = tempNode;
            }
            return this;
        }
	/**
	 * Return the entire sequence of this sequence as a String
	 * 
	 * @return a string representation of this sequence of characters
	 */
    @Override
	public String toString() {
            String toStr = "";
            for (int i = 0; i < length; i++) {
                if (getNodeAt(i) != null) {
                  toStr = toStr + getNodeAt(i).data + "";
                }
            } 
            return toStr; 
        }
       
        private boolean isEmpty() {
            return length() < 0 && firstNode == null; 
        }
   
        private CNode getNodeAt(int position) {
          if (position < 0 || position >= length()) { 
                return null;
            }
            CNode currentNode = firstNode;

            for (int i = 0; i < position; i++) {
                currentNode = currentNode.next;
            }
            return currentNode;

        }
  
        private class CNode {
     
            private char data;
            private CNode next;
        
            private CNode(char c) {
                data = c;
                next = null;            
            }
        
             private CNode(char c, CNode nextNode) {
                data  = c;
                next = nextNode;
            }    
        } //End of CNode
}//EOF
