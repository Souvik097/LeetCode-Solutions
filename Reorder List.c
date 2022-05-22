/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode* midNode(struct ListNode* head)
{
    struct ListNode *fast=head,*slow=head;
    while(fast->next!=NULL && fast->next->next!=NULL)
    {
        fast=fast->next->next;
        slow=slow->next;
    }
    
    return slow;
}

struct ListNode* reverse(struct ListNode* head)
{
    struct ListNode *curr=head,*prev=NULL,*next=NULL;
    while(curr!=NULL)
    {
        next=curr->next;
        curr->next=prev;
        prev=curr;
        curr=next;
    }
    
    return prev;
}

void reorderList(struct ListNode* head)
{
    struct ListNode *midnode=midNode(head);
    struct ListNode *nextToMid=midnode->next;
    midnode->next=NULL;
    struct ListNode *curr2=reverse(nextToMid);
    struct ListNode *curr1=head,*curr1Next;
    while(curr1!=NULL && curr2!=NULL)
    {
        curr1Next=curr1->next;
		curr1->next=curr2;
        curr1=curr2;
        curr2=curr1Next;
    }
}
