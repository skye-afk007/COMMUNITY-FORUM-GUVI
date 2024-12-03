//NavBar
function hideIconBar(){
    var iconBar = document.getElementById("iconBar");
    var navigation = document.getElementById("navigation");
    iconBar.setAttribute("style", "display:none;");
    navigation.classList.remove("hide");
}

function showIconBar(){
    var iconBar = document.getElementById("iconBar");
    var navigation = document.getElementById("navigation");
    iconBar.setAttribute("style", "display:block;");
    navigation.classList.add("hide");
}

//Comment
function showComment(){
    var commentArea = document.getElementById("comment-area");
    commentArea.classList.remove("hide");
}

//Reply
function showReply(){
    var replyArea = document.getElementById("reply-area");
    replyArea.classList.remove("hide");
}
// Toggle Post Modal
document.getElementById("addPostButton").addEventListener("click", function () {
    document.getElementById("postModal").classList.remove("hide");
});
document.getElementById("closePostModal").addEventListener("click", function () {
    document.getElementById("postModal").classList.add("hide");
});

// Handle Post Form Submission
document.getElementById("postForm").addEventListener("submit", function (e) {
    e.preventDefault();
    const title = document.getElementById("postTitle").value;
    const content = document.getElementById("postContent").value;

    fetch('/posts', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ title, content, userId: 1 }) // Example userId
    })
        .then(response => response.json())
        .then(data => {
            alert("Post added successfully!");
            document.getElementById("postModal").classList.add("hide");
        });
});

// Handle Comment Form Submission
document.getElementById("commentForm").addEventListener("submit", function (e) {
    e.preventDefault();
    const content = document.getElementById("commentContent").value;

    fetch('/comments', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ content, postId: 1, userId: 1 }) // Example postId and userId
    })
        .then(response => response.json())
        .then(data => {
            alert("Comment added successfully!");
            const commentList = document.getElementById("commentList");
            const newComment = document.createElement("li");
            newComment.textContent = content;
            commentList.appendChild(newComment);
        });
});
